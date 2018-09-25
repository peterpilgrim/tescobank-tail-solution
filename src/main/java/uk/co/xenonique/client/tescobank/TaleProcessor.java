/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2018 by Peter Pilgrim, Milton Keynes, P.E.A.T UK LTD
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package uk.co.xenonique.client.tescobank;

import java.io.*;
import java.util.ArrayList;
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
        total.set(words.length + total.get());

        for (String word : words) {
            if (word.length() > 0) {
                final String insensitiveWord = word.toLowerCase();
                if (wordCountMap.containsKey(insensitiveWord)) {
                    int count = wordCountMap.get(insensitiveWord);
                    wordCountMap.put(insensitiveWord, count + 1);
                } else {
                    wordCountMap.put(insensitiveWord, 1);
                }
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

    public void process(InputStream inputStream) {
        LineNumberReader lineNumberReader = null;
        try {
            lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream));
            String line;
            while ( ( line = lineNumberReader.readLine())!= null ) {
                System.out.println(line);
                process(line);
                System.out.printf("total=%s\n", total.get());
            }
        } catch (IOException e) {
            if ( lineNumberReader != null ) {
                try {
                    lineNumberReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public SortedMap<String, Integer> getWordCountMap() {
        return wordCountMap;
    }
}
