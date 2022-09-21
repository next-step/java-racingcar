package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class StringCalculatorTest {


    private StringCalculator stringCalculator;

    @BeforeEach
    private void setStringCalculator() {
        stringCalculator = new StringCalculator();
    }

    private static Stream<Arguments> providesForAddOperation() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0)
        );
    }

    @ParameterizedTest(name = "쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 반환한다.")
    @MethodSource("providesForAddOperation")
    void addOperation(String text, Object result) {
        Assertions.assertThat(stringCalculator.addOperation(text)).isEqualTo(result);
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void textCheck() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(stringCalculator.addOperation("")).isEqualTo(0),
                () -> Assertions.assertThat(stringCalculator.addOperation(null)).isEqualTo(0)
        );
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void textCheckProvidesANumber() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(stringCalculator.addOperation("1")).isEqualTo(1),
                () -> Assertions.assertThat(stringCalculator.addOperation("22")).isEqualTo(22)
        );
    }

    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @Test
    void addOperationSeparateByRest() {
        Assertions.assertThat(stringCalculator.addOperation("1,2")).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마 이외에 콜론을 사용할 수 있다.")
    @Test
    void addOperationSeparateByRestAndColon() {
        Assertions.assertThat(stringCalculator.addOperation("1,2:3")).isEqualTo(6);
    }
}
