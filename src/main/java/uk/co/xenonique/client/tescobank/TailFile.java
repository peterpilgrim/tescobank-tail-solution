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
import java.util.concurrent.atomic.AtomicReference;

/**
 * The type TailFile
 *
 * @author Peter Pilgrim (peter)
 */
public class TailFile {
    public String readLast(List<String> lines) {
        AtomicReference<String> lastLine = new AtomicReference<>("");
        lines.stream().forEach( line -> lastLine.set( line));
        return lastLine.get();
    }

    public String readLast(InputStream inputStream) {
        List<String> lines = new ArrayList<>();
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream));

        String line = null;
        try {
            while ( ( line = lineNumberReader.readLine())!= null ) {
                lines.add(line);
            }
            return readLast(lines);
        }
        catch (IOException ioe) {
            throw new RuntimeException("Unable read input stream", ioe);
        }
    }
}
