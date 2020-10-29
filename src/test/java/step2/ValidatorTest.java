package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ValidatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @DisplayName("사칙연산 기호에 해당되지 않을 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = "3 * 5 & 5")
    public void validateOperatorTypeCheck(String inputData) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(inputData);
                }).withMessageMatching("사칙연산 기호가 아닙니다");
    }


    @DisplayName("입력값이 null이거나 비어있을 때 예외처리")
    @ParameterizedTest
    @MethodSource("blankStrings")
    public void validateIsEmptyCheck(String blankData) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(blankData);
                }).withMessageMatching("입력값이 비어있습니다");
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }
}
