package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {

    }

    @Test
    void subTest(){
        assertThat(calculator.calculator((double) 40,(double) 20,"-")).isEqualTo( 20);
    }
    @Test
    void addTest(){
        assertThat(calculator.calculator((double) 1,(double) 2,"+")).isEqualTo(3);
    }

    @Test
    void multiplyTest(){
        assertThat(calculator.calculator((double)20,(double)4,"*")).isEqualTo(80);
    }

    @Test
    void divideTest(){
        assertThat(calculator.calculator((double)20,(double)4,"/")).isEqualTo(5);
    }

}