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



}
