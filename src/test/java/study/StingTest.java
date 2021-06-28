package study;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StingTest {

    @Test
    void test() {
        // Assertions.assertEquals(4, 3 + 2);
    }

    @Test
    void split() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void dyrn2() {
        String actual = "(1,2)";
        actual = actual.replace("(", "");
        actual = actual.replace(")", "");
        assertThat(actual).contains("1,2");
    }

    @Test
    void dyrn3() {
        String actual = "abc";
        int selectoned = actual.indexOf("a");
//        assertEquals(0, selectoned);
        assertThat(selectoned).isEqualTo(0);
    }




}
