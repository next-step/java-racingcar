package study.calculator;

import org.junit.jupiter.api.Test;
import study.calculator.InputNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class InputNumberTest {

    @Test
    void create() {
        InputNumber number = new InputNumber("1");
        assertThat(number).isEqualTo(new InputNumber(1));
    }

    @Test
    void add() {
        InputNumber result = new InputNumber("1").add(new InputNumber("2"));
        assertThat(result).isEqualTo(new InputNumber(3));
    }

    @Test
    void subtract() {
        InputNumber result = new InputNumber("5").subtract(new InputNumber("3"));
        assertThat(result).isEqualTo(new InputNumber(2));
    }

    @Test
    void multiply() {
        InputNumber result = new InputNumber("4").multiply(new InputNumber("2"));
        assertThat(result).isEqualTo(new InputNumber(8));
    }

    @Test
    void divide() {
        InputNumber result = new InputNumber("30").divide(new InputNumber("5"));
        assertThat(result).isEqualTo(new InputNumber(6));
    }
}
