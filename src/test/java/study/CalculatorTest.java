package study;

import calcurator.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


    @Test
    void testCalculatorAdd(){
        assertThat(Calculator.add(1, 2)).isEqualTo(3);
        assertThat(Calculator.add(1, 4)).isEqualTo(5);
        assertThat(Calculator.add(100, 200)).isEqualTo(300);


    }

    @Test
    void testCalculatorSubtract(){
        assertThat(Calculator.subtract(2, 1)).isEqualTo(1);
        assertThat(Calculator.subtract(1, 4)).isEqualTo(-3);


    }


    @Test
    void testCalculatorMultiply(){
        assertThat(Calculator.multiply(2, 1)).isEqualTo(2);

    }



}
