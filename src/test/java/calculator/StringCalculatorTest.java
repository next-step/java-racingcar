package calculator;

import errors.EmptyArgumentException;
import errors.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"5 + 4 * 3 * 9", "5 + 5 - 2 / 4 * 2", "1 + 1 * 2 ! 9"})
    public void calculateTest(String input) throws EmptyArgumentException, InvalidInputException {
        //when, then
        assertThat(StringCalculator.calculate(input)).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 + 4 * 3 * 9", "5 + 5 - 2 / 4 * 2", "1 + 1 * 2 ! 9"})
    @DisplayName("사칙연산 예외테스트")
    public void operatorExceptionTest(String input) {
        //when, then
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            StringCalculator.calculate(input);
//        });
        assertThatExceptionOfType(InvalidInputException.class).isThrownBy(() -> {
            StringCalculator.calculate(input);
        });
    }

    @Test
    @DisplayName("input 예외테스트")
    public void inputExceptionTest() {
        //given
        String input = null;
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(input);
        });
    }

    @ParameterizedTest
//    @ValueSource(strings = {"+", "-", "*", "/"})
    @CsvSource(value = {"5,2", "4,3", "6,9"})
    @DisplayName("Enum 테스트")
    public void enumTest(int input1, int input2) {
        //given
//        String operator = StringCalculator.Operator.ADD.getOperator();
        //then
//        assertThat(operator.contains(input)).isTrue();
        //when
        int answer = StringCalculator.Operator.DIVIDE.expression.apply(input1, input2);
        //then
        assertThat(answer).isEqualTo(5);
    }
}