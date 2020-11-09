package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ValidatorTest {



    @DisplayName("사칙연산 기호 포함 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"*:true", "^:false", "-:true", "/:true", "@:false"}, delimiter = ':')
    public void isContainsOperatorTypeTest(String inputData, boolean expected) {
        assertThat(Operator.isContainOperator(inputData)).isEqualTo(expected);
    }

    @DisplayName("사칙연산 기호 미포함시 예외처리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 3 / 5 * 7 ^ 2"})
    public void validateIsCorrectOperatorTypeTest(String inputData) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputParser.getCalculationMaterial(inputData);
                }).withMessageMatching("사칙연산 기호가 아닙니다");
    }


    @DisplayName("입력값이 null이거나 비어있을 때 예외처리")
    @ParameterizedTest
    @MethodSource("blankStrings")
    public void validateIsEmptyCheck(String blankData) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputParser.getCalculationMaterial(blankData);
                }).withMessageMatching("입력값이 비어있습니다");
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }
}
