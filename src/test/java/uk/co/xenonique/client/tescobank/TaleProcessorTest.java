package uk.co.xenonique.client.tescobank;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * A unit test TaleProcessorTest to verify the operation of TaleProcessorTest
 *
 * @author Peter Pilgrim
 */
public class TaleProcessorTest {

    private final static String TEXT = "Red Yellow Red GREEN RED Yellow red green yellow Red";
    private TaleProcessor processor;

    @Before
    public void setup() {
        this.processor = new TaleProcessor();
    }

    @Test
    public void process_total_number_of_words() {
        processor.process(TEXT);
        assertThat(processor.getTotal(), is(10));
    }

    @Test
    public void process_words_with_specific_counts() {
        processor.process(TEXT);
        assertThat(processor.getWord("red"), is(5));
        assertThat(processor.getWord("yellow"), is(3));
        assertThat(processor.getWord("green"), is(2));
    }

    @Test
    public void process_words_retrieve_descending_order() {
        processor.process(TEXT);
        List<String> words = processor.getOrderedWords();
        assertThat(words, is(Arrays.asList("red", "yellow", "green" )));
    }

    @Test
    public void process_words_from_input_stream() {
        InputStream inputStream = this.getClass().getResourceAsStream("/crawl.txt");
        assertThat(inputStream, notNullValue());
        
        processor.process(inputStream);
        assertThat(processor.getTotal(), is(96));
        System.out.printf("wordCountMap=%s\n", processor.getWordCountMap());
        assertThat(processor.getWord("the"),is(27));
        assertThat(processor.getWord("a"),is(4));
        assertThat(processor.getWord("an"),is(2));
        assertThat(processor.getWord("of"),is(2));
        assertThat(processor.getWord("freedom"),is(1));
        assertThat(processor.getWord("galactic"),is(1));
        assertThat(processor.getWord("war."),is(1));
    }
}
