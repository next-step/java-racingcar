package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class CalculatorSignTest {

    @Test
    @DisplayName(value = "Enum의 CodeName으로 valueOf 기능을 구현하고 테스트")
    public void createCalculatorSing() {
        CalculatorSign calculatorSign = CalculatorSign.valueOf("ADDITION");
        assertThat(calculatorSign).isEqualTo(CalculatorSign.ADDITION);

        String plus = "+";
        CalculatorSign calculatorSign1 = CalculatorSign.findByCodeName(plus);
        assertThat(calculatorSign1).isEqualTo(CalculatorSign.ADDITION);

    }

    @Test
    @DisplayName(value = "계산기의 각 기능들 테스트")
    public void check_CalculatorFunction() throws Exception {
        //given 
        int a = 10;
        int b = 5;
        
        assertThat(addition(a,b)).isEqualTo(15);
        assertThat(subtraction(a,b)).isEqualTo(5);
        assertThat(multiplication(a,b)).isEqualTo(50);
        assertThat(division(a,b)).isEqualTo(2);
    }
    
    @Test
    @DisplayName(value = "두 값의 더하기 기능 테스트")
    public int addition(int a, int b) {
        return a + b;
    } 
    
    @Test
    @DisplayName(value = "두 값의 나누기 기능 테스트")
    public int division(int a, int b) {
        return a / b;
    } 
    
    @Test
    @DisplayName(value = "두 값의 곱하기 기능 테스트")
    public int multiplication(int a, int b) {
        return a * b;
    } 
    
    @Test
    @DisplayName(value = "두 값의 빼기 기능 테스트")
    public int subtraction(int a, int b) {
        return a - b;
    }
}
