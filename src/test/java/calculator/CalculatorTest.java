package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(()->{
            cal.divide(5,0);
        }).isInstanceOf(ArithmeticException.class);   //ArithmeticException
    }
    @DisplayName("구현한 계산기 테스트")
    @Test
    void calculatorTest(){
        String input = "5 + 4 * 6 / 2 - 5";
//        String input = "1";
        assertThat(cal.calculate(input)).isEqualTo(22);
    }
}
