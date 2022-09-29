package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다")
    @ParameterizedTest(name = "{displayName} {index} => sum of ''{0}'' is {1}")
    @CsvSource(value = {" '1,2', 3 ", " '1,2,3', 6 ", " '1,2:3', 6 "})
    void sumWhenDefaultDelimiter(String source, int expected) {
        // given
        StringCalculator sut = new StringCalculator();

        // when
        int actual = sut.sum(source);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자는 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다")
    @ParameterizedTest(name = "{displayName} {index} => sum of ''{0}'' is {1}")
    @CsvSource(value = {" '//;\n1;2;3', 6 "})
    void sumWhenCustomDelimiter(String source, Integer expected) {
        // given
        StringCalculator sut = new StringCalculator();

        // when
        Integer actual = sut.sum(source);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자와 디폴트 구분자는 함께 사용할 수 있다")
    @ParameterizedTest(name = "{displayName} {index} => sum of ''{0}'' is {1}")
    @CsvSource(value = {" '//;\n1;2,3', 6 "})
    void sumWhenCustomAndDefaultDelimiter(String source, Integer expected) {
        // given
        StringCalculator sut = new StringCalculator();

        // when
        Integer actual = sut.sum(source);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("빈 문자열이나 null을 전달하는 경우 0을 반환한다")
    @ParameterizedTest(name = "{displayName}")
    @NullAndEmptySource
    void zeroWhenEmptyString(String emptySource) {
        // given
        StringCalculator sut = new StringCalculator();

        // when
        Integer actual = sut.sum(emptySource);

        // then
        Integer expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @ParameterizedTest(name = "{displayName} {index} => ''{0}''")
    @ValueSource(strings = {"1", "2", "0"})
    void selfWhenOneNumber(String source) {
        // given
        StringCalculator sut = new StringCalculator();

        // when
        Integer actual = sut.sum(source);

        // then
        Integer expected = Integer.valueOf(source);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 던진다")
    @ParameterizedTest(name = "{displayName} {index} => ''{0}''")
    @ValueSource(strings = {"나는야 문자열", "-1:23", "-1,-2,4"})
    void exceptionWhenNotPositiveNumber(String wrongSource) {
        // given
        StringCalculator sut = new StringCalculator();

        // when & then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> sut.sum(wrongSource));
    }
}
