package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @DisplayName("요구사항1 - split 1,2")
    @Test
    void splitTest1() {
        // given
        String input = "1,2";

        // when
        String[] splitStrings = input.split(",");

        // then
        assertThat(splitStrings).containsExactly("1","2");
    }

    @DisplayName("요구사항1 - split 1")
    @Test
    void splitTest2() {
        // given
        String input = "1";

        // when
        String[] splitStrings = input.split(",");

        // then
        assertThat(splitStrings).contains("1");
    }

    @DisplayName("요구사항2 - substring")
    @Test
    void substringTest() {
        // given
        String input = "(1,2)";

        // when
        String actual = input.substring(1, input.length() - 1);

        // then
        assertThat(actual).isEqualTo("1,2");
    }
}
