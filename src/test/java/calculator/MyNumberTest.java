package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyNumberTest {
    @Test
    void create() {
        assertThat(new MyNumber("1")).isEqualTo(new MyNumber(1));
    }

    @Test
    void plus() {
        MyNumber actual = new MyNumber("1").plus(new MyNumber(2));
        assertThat(actual).isEqualTo(new MyNumber(3));
    }

    @Test
    void minus() {
        MyNumber actual = new MyNumber("2").minus(new MyNumber(1));
        assertThat(actual).isEqualTo(new MyNumber(1));
    }

    @Test
    void times() {
        MyNumber actual = new MyNumber("1").multiple(new MyNumber(2));
        assertThat(actual).isEqualTo(new MyNumber(2));
    }

    @Test
    void devideBy() {
        MyNumber actual = new MyNumber("4").divideBy(new MyNumber(2));
        assertThat(actual).isEqualTo(new MyNumber(2));
    }
}
