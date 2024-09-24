package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    public void splitTestToArrayMultiValue() {

        //given
        String inputValue = "1,2";

        // when
        String[] split = inputValue.split(",");

        // then
        assertThat(split).contains("1", "2");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    public void splitTestToArraySingleValue() {

        //given
        String inputValue = "1,";

        // when
        String[] split = inputValue.split(",");

        // then
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1");
    }

    @Test
    public void testForParenthesis() {

        // given
        String testForParenthesis = "(1,2)";

        // when & then
        assertThat(testForParenthesis.substring(1, 4)).isEqualTo("1,2");
    }
}
