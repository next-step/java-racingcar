package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyIntegerTest {

    @Test
    void add() {
        MyInteger result = new MyInteger(1).add(new MyInteger(2));
        assertThat(result).isEqualTo(new MyInteger(3));
    }

    @Test
    void subtract() {
        MyInteger result = new MyInteger(1).subtract(new MyInteger(2));
        assertThat(result).isEqualTo(new MyInteger(-1));
    }

    @Test
    void multiply() {
        MyInteger result = new MyInteger(1).multiply(new MyInteger(2));
        assertThat(result).isEqualTo(new MyInteger(2));
    }

    @Test
    void divide() {
        MyInteger result = new MyInteger(1).divide(new MyInteger(2));
        assertThat(result).isEqualTo(new MyInteger(0));
    }

    @Test
    void divideByZero() {
        assertThatThrownBy(() -> new MyInteger(1).divide(new MyInteger(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다");
    }

}
