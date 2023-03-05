package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        final String[] actual = "1,".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void charAt(){
        final char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }
}
