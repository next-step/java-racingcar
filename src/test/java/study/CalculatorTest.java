package study;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void SetUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("+ test")
    void addtest(){
        assertThat(2).isEqualTo(calculator.add(1,1));
    }

    @Test
    @DisplayName("- test")
    void substracttest(){
        assertThat(1).isEqualTo(calculator.subtract(2,1));
    }

    @Test
    @DisplayName("x test")
    void multiplytest(){
        assertThat(4).isEqualTo(calculator.multiply(2,2));
    }

    @Test
    @DisplayName("/ test")
    void dividetest(){
        assertThat(4).isEqualTo(calculator.divide(8,2));
    }

    @Test
    @DisplayName("string divide")
    void sep(){
        String str = "3 + 3";
        String[] result = {"3" , "+", "3"};
        assertThat(result).isEqualTo(calculator.seperate(str));

    }

    @Test
    @DisplayName("string calculating")
    void strcal(){
        String str = "1 + 2 + 3";
        String[] result = calculator.seperate(str);
        int num = 6;
        assertThat(num).isEqualTo(calculator.calculateString(result));
    }
}
