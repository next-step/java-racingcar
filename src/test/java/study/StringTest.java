package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringTest {
    @Test
    void splitTest() {
        String dummy1 = "1,2";
        String dummy2 = "1";

        String[] dummy1Array = dummy1.split(",");
        String[] dummy2Array = dummy2.split(",");

        assertThat(dummy1Array).containsExactly("1","2");
        assertThat(dummy2Array).contains("1");
    }
}