package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void splitTest(){
        // given
        String str = "1,2";

        // when
        String [] result = str.split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }
}
