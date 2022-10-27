package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {

    @Test
    void ReversedSequenceToString() {
        ReversedSequence str = new ReversedSequence("abcdef");
        String text = str.toString();
        String expected1 = "fedcba";
        assertThat(text).isEqualTo(expected1);
    }

    @Test
    void ReversedSequenceCharAt() {
        ReversedSequence str = new ReversedSequence("abcdef");
        char expected2 = 'e';
        char ch = str.charAt(1); // 'e'
        assertThat(ch).isEqualTo(expected2);
    }

    @Test
    void ReversedSequenceLength() {
        ReversedSequence str = new ReversedSequence("abcdef");
        int expected3 = 6;
        int length = str.length(); // 'e'
        assertThat(length).isEqualTo(expected3);
    }

    @Test
    void ReversedSequenceSubSequence() {
        ReversedSequence str = new ReversedSequence("abcdef");
        CharSequence expected4 = "edc";
        CharSequence sub = str.subSequence(1, 4); // 'e'
        assertThat(sub).isEqualTo(expected4);
    }
}
