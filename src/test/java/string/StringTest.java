package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @DisplayName("구분자(,)로 문자열 분리")
    @ParameterizedTest
    @CsvSource(value = {"1,2:2", "1:1"}, delimiter = ':')
    void splitNumbers(String values, int expected) {
        //when
        String delimiter = ",";
        String[] actual = values.split(delimiter);

        //then
        assertThat(actual.length).isEqualTo(expected);
    }

    @DisplayName("substring을 이용해서 괄호안의 문자열 반환")
    @ParameterizedTest
    @CsvSource(value = {"(1):1", "(1,2):1,2"}, delimiter = ':')
    void substring(String values, String expected) {
        //given
        String leftParenthesis = "(";
        String rightParenthesis = ")";

        //when
        String actual = values.substring(values.indexOf(leftParenthesis) + 1, values.indexOf(rightParenthesis));

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("charAt 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void charAtWithWrongIndex(int index) {
        //given
        String value = "abc";

        //when
        assertThatThrownBy(() -> value.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}
