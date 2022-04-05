package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void splitTest() {
        //given
        String data = "1,2";

        //when
        String[] result = data.split(",");

        //then
        assertThat(result).containsExactly("1", "2");

    }
}
