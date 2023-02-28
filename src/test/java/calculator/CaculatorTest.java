package calculator;
import calcuator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CaculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {

    }

    @Test
    void inputValidateTest(){
        String input = "202 + 32 * 40 / 2";
        calculator.inputValidate(input);
    }
    @Test
    void subTest(){
        assertThat(calculator.calculator(40,20,"-")).isEqualTo(20);
    }
    @Test
    void addTest(){
        assertThat(calculator.calculator(1,2,"+")).isEqualTo(3);
    }

    @Test
    void multiplyTest(){
        assertThat(calculator.calculator(20,4,"*")).isEqualTo(80);
    }

    @Test
    void divideTest(){
        assertThat(calculator.calculator(20,4,"/")).isEqualTo(5);
    }

}
