package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("입력 값이 null이거나 빈 공백 문자열로 연산을 하면 IllegalArgumentException 발생")
    @Test
    void emptyString_thenThrowIllegalArgumentException(){
        Calculator calculator = new Calculator();

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(null));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(""));
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("\n    \t"));
    }

    @DisplayName("사직연산 기호가가 아닌 기호로 연산을 하면 IllegalArgumentException 발생")
    @Test
    void notSupportedOperator_thenThrowIllegalArgumentException(){
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("1 ! 2"));
    }

}
