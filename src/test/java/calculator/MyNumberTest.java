package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyNumberTest {

    @Test
    void 숫자생성() {
        MyNumber number = new MyNumber("1");
        assertThat(number).isEqualTo(new MyNumber(1));
    }

    @Test
    void 더하기() {
        MyNumber actual = new MyNumber("1").plus(new MyNumber("2"));
        assertThat(actual).isEqualTo(new MyNumber("3"));
    }

    @Test
    void 빼기() {
        MyNumber actual = new MyNumber("3").minus(new MyNumber("2"));
        assertThat(actual).isEqualTo(new MyNumber("1"));
    }

    @Test
    void 곱하기() {
        MyNumber actual = new MyNumber("3").multiply(new MyNumber("2"));
        assertThat(actual).isEqualTo(new MyNumber("6"));
    }

    @Test
    void 나누기() {
        MyNumber actual = new MyNumber("4").division(new MyNumber("2"));
        assertThat(actual).isEqualTo(new MyNumber("2"));
    }

    @Test
    void 나누기_0으로_나눌_때_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MyNumber("4").division(new MyNumber("0"));
        });
    }
}
