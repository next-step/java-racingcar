package step01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 메서드로 값을 분리한다")
    void splitTest01() {
        //given
        String inputValue = "1,2";

        //when
        String[] splitValues = inputValue.split(",");

        //then
        assertThat(splitValues).contains("1");
        assertThat(splitValues).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 메서드로 원하는 범위의 값을 추출한다")
    void substringTest01() {
        //given
        String inputValue = "(1,2)";

        //when
        String substringValue = inputValue.substring(1, 4);

        //then
        assertThat(substringValue).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("chatAt 메서드로 원하는 char 을 추출한다")
    void chatAtTest(int index, char expectedValue) {
        //given
        String inputValue = "abc";

        //when, then
        assertThat(inputValue.charAt(index)).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("문자열 범위를 벗어날 경우, StringIndexOutOfBoundsException 예외를 발생시킨다")
    void charAtStringIndexOutOfBoundsExceptionTest() {
        //given
        String inputValue = "abc";

        //when, then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> inputValue.charAt(3));
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> inputValue.charAt(-1));
    }

}
