package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void addTest() {
        assertThat(cal.add(1,5)).isEqualTo(6);
        assertThat(cal.add(-6,5)).isEqualTo(-1);
        assertThat(cal.add(-5,-2)).isEqualTo(-7);
    }

    @Test
    void substractTest() {
        assertThat(cal.substract(-5,4)).isEqualTo(-9);
        assertThat(cal.substract(-5,-4)).isEqualTo(-1);
        assertThat(cal.substract(0,-4)).isEqualTo(4);
    }

    @Test
    void multipleTest() {
        assertThat(cal.multiple(0,5)).isEqualTo(0);
        assertThat(cal.multiple(-1,5)).isEqualTo(-5);
        assertThat(cal.multiple(-1,-5)).isEqualTo(5);
    }

    @Test
    void divideTest() {
        assertThat(cal.divide(1,4)).isEqualTo(0);
        assertThat(cal.divide(5,4)).isEqualTo(1);
        assertThat(cal.divide(0,4)).isEqualTo(0);
//        assertThat(cal.divide(5,0)).isEqualTo(0);   //ArithmeticException
    }
}
