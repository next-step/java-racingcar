package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyNumberTest {

    @Test
    void create() {
        assertThat(new MyNumber(1)).isEqualTo(new MyNumber(1));
    }

    @Test
    void plus() {
        assertThat(new MyNumber(1).plus(new MyNumber(7))).isEqualTo(new MyNumber(8));
    }

    @Test
    void minus() {
        assertThat(new MyNumber(1).minus(new MyNumber(7))).isEqualTo(new MyNumber(-6));
    }

    @Test
    void multiple() {
        assertThat(new MyNumber(2).multiply(new MyNumber(7))).isEqualTo(new MyNumber(14));
    }

    @Test
    void divide() {
        assertThat(new MyNumber(20).divide(new MyNumber(7))).isEqualTo(new MyNumber(2));
    }
}
