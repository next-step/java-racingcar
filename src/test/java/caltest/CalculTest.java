package caltest;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculTest {

    private Calculator calculator = new Calculator();

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생 하는지 테스트")
    @Test
    void inputNullOrEmptyTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String userInput = "2 +   * 2 / 2";
            calculator.setUserInput(userInput);
            calculator.caculateUserInput();
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void checkPermittedOperator(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String userInput = "2 $ 6 * 5 / 4";
            calculator.setUserInput(userInput);
            calculator.caculateUserInput();
        });
    }
}
