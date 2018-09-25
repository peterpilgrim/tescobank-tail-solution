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
            System.out.printf("\ntotal words: %d\n\n", processor.getTotal());

            processor.getOrderedWords().stream().forEach(word -> {
                int count = processor.getWord(word);
                System.out.printf("[%s] found %d %s.\n", word, count, (count == 1 ? "time" : "times"));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        new TaleProcessorApp().doWork(args[0]);
    }
}
