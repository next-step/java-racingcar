package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("charAt 메서드를 활용해 특정 위치의 문자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    public void testForCharAt(String inputValue) {

        // when & then
        assertThat('a').isEqualTo(inputValue.charAt(0));
        assertThat('b').isEqualTo(inputValue.charAt(1));
        assertThat('c').isEqualTo(inputValue.charAt(2));
    }

    @DisplayName("charAt 으로 주어진 문자열의 길이보다 큰 값을 조회 할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    public void testForCharAtException(String inputValue) {

        // when & then
        assertThatThrownBy(() -> inputValue.charAt(inputValue.length() + 1))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
