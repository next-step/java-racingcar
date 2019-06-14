package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private int x;
    private int y;

    @BeforeEach
    void init(){
        x = 10;
        y = 5;
    }

    @Test
    @DisplayName("덧셈 테스트")
    void additionTest(){
        int addition = Calculator.addition(x, y);
        assertThat(addition).isEqualTo(15);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractionTest(){
        int addition = Calculator.subtraction(x, y);
        assertThat(addition).isEqualTo(5);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplicationTest(){
        int addition = Calculator.multiplication(x, y);
        assertThat(addition).isEqualTo(50);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divisionTest(){
        int addition = Calculator.division(x, y);
        assertThat(addition).isEqualTo(2);
    }

}
