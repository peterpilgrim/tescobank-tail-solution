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
