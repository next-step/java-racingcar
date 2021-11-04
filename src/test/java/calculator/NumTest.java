package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumTest {

    @Test
    void create() {
        assertThat(new Num("1")).isEqualTo(new Num(1));
    }

    @Test
    void addition() {
        Num actual = new Num("1").plus(new Num(2));
        assertThat(actual).isEqualTo(new Num(3));
    }

    @Test
    void subtraction() {
        Num actual = new Num("5").minus(new Num(2));
        assertThat(actual).isEqualTo(new Num(3));
    }

    @Test
    void multiplication() {
        Num actual = new Num("2").times(new Num(2));
        assertThat(actual).isEqualTo(new Num(4));
    }

    @Test
    void division() {
        Num actual = new Num("5").divideBy(new Num(2));
        assertThat(actual).isEqualTo(new Num(2));
    }
}
