package stringcalculator.arithmeticcomponent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static stringcalculator.arithmeticcomponent.ArithmeticOperator.*;

@DisplayName("수식의 연산자를 위한 테스트")
class ArithmeticOperatorTest {

    @DisplayName("연산자가 모두 존재하는지 확인")
    @Test
    void checkOperatorsTest() {
        // then
        assertThat(ArithmeticOperator.values())
                .containsExactly(PLUS, MINUS, MULTIPLY, DIVIDE);
    }

    @DisplayName("연산자를 위한 수식이 존재하는지 확인")
    @Test
    void buildOperatorTest() {
        // then
        assertThat(ArithmeticOperator.values())
                .extracting(ArithmeticOperator::function)
                .isNotEmpty();
    }

    @DisplayName("문자열로 된 산술연산자 +, -, *, / 가 해당하는 enum으로 변환되는지 확인")
    @Test
    void convertStringToEnumTest() {
        // when
        ArithmeticOperator plus = ArithmeticOperator.findByOperator("+");
        ArithmeticOperator minus = ArithmeticOperator.findByOperator("-");
        ArithmeticOperator multiply = ArithmeticOperator.findByOperator("*");
        ArithmeticOperator divide = ArithmeticOperator.findByOperator("/");
        // then
        assertAll(
                () -> assertThat(plus).isEqualTo(PLUS),
                () -> assertThat(minus).isEqualTo(MINUS),
                () -> assertThat(multiply).isEqualTo(MULTIPLY),
                () -> assertThat(divide).isEqualTo(DIVIDE)
        );
    }

    @DisplayName("잘못된 연산자 문자열을 enum으로 변환할때 예외를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"!", "=", "%", "&", " "})
    void checkInvalidOperatorTest(String invalidOperator) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ArithmeticOperator.findByOperator(invalidOperator);
        });
    }

    @DisplayName("유효한 연산자 문자열이 정상적으로 체크가 되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void checkValidOperatorTest(String validOperator) {
        // when
        boolean isContained = ArithmeticOperator.isContained(validOperator);
        // then
        assertThat(isContained).isTrue();
    }
}
