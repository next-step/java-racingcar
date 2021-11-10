package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {


    @Test
    @DisplayName("Number class 생성자 테스트")
    void NumberConstructor() {
        Number num = new Number("3");
        assertThat(num.getNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("Number.equals 테스트")
    void NumberEquals() {
        Number num = new Number("3");
        assertThat(num.equals(new Number(3))).isTrue();
    }

    @Test
    @DisplayName("Number.plus 테스트")
    void NumberPlus() {
        Number first = new Number(1);
        Number second = new Number(2);
        Number result = new Number(3);

        assertThat(first.plus(second).equals(result)).isTrue();
    }

    @Test
    @DisplayName("Number.minus 테스트")
    void NumberMinus() {
        Number first = new Number(100);
        Number second = new Number(20);
        Number result = new Number(80);

        assertThat(first.minus(second).equals(result)).isTrue();
    }

    @Test
    @DisplayName("Number.times 테스트")
    void NumberTimes() {
        Number first = new Number(5);
        Number second = new Number(2);
        Number result = new Number(10);

        assertThat(first.times(second).equals(result)).isTrue();
    }

    @Test
    @DisplayName("Number.dividedBy 테스트")
    void NumberDividedBy() {
        Number first = new Number(10);
        Number second = new Number(2);
        Number result = new Number(5);

        assertThat(first.dividedBy(second).equals(result)).isTrue();
    }


}
