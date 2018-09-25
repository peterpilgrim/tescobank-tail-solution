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

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * A unit test TailFileTest to verify the operation of TailFileTest
 *
 * @author Peter Pilgrim
 */
public class TailFileTest {

    @Test
    public void read_last_item_from_input_stream()
    {
        InputStream inputStream = this.getClass().getResourceAsStream("/crawl.txt");
        assertThat(inputStream, not(nullValue()));

        TailFile tail = new TailFile();
        assertThat( tail.readLast(inputStream), is("freedom to the galaxy...."));
    }

    @Test
    public void read_last_item_in_a_stream() {
        List<String> lines = Arrays.asList("one", "two", "three", "four", "five");
        TailFile tail = new TailFile();
        assertThat(tail.readLast(lines), is("five"));
    }
}
