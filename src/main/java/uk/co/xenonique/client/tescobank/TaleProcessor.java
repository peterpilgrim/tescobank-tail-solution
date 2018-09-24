package uk.co.xenonique.client.tescobank;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * The type TaleProcessor
 *
 * @author Peter Pilgrim (peter)
 */
public class TaleProcessor {
    private AtomicInteger total = new AtomicInteger();
    private SortedMap<String, Integer> wordCountMap = new TreeMap<>();

    public void process(String text) {
        String words[] = text.split("\\s+");
        total.set(words.length);

        for (String word : words) {
            final String insensitiveWord = word.toLowerCase();
            if (wordCountMap.containsKey(insensitiveWord)) {
                int count = wordCountMap.get(insensitiveWord);
                wordCountMap.put(insensitiveWord, count + 1);
            } else {
                wordCountMap.put(insensitiveWord, 1);
            }
        }
    }


    public int getTotal() {
        return total.get();
    }

    public Integer getWord(String word) {
        final String insensitiveWord = word.toLowerCase();
        return wordCountMap.containsKey(insensitiveWord) ? wordCountMap.get(insensitiveWord) : 0;
    }

    public List<String> getOrderedWords() {
        return wordCountMap.entrySet().stream().sorted(
                (e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(element -> element.getKey())
                .collect(Collectors.toList());
    }
}
