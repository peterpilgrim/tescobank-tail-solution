package uk.co.xenonique.client.tescobank;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The type TaleProcessorApp
 *
 * @author Peter Pilgrim
 */
public class TaleProcessorApp {

    public void doWork(String filename) {
        TaleProcessor processor = new TaleProcessor();

        Path path = FileSystems.getDefault().getPath(filename);

        try {
            Files.lines(path).forEach(line ->
                    processor.process(line));
            System.out.printf("total words: %d\n", processor.getTotal());

            processor.getOrderedWords().stream().forEach(word -> {
                int count = processor.getWord(word);
                System.out.printf("[%s] found %d %ss\n", word, count, (count == 1 ? "time" : "times"));
            });
        }
        catch (IOException e)    {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        new TaleProcessorApp().doWork(args[0]);
    }
}
