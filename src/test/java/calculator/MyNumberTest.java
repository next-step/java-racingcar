package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyNumberTest {
    @Test
    public void create() {
        assertThat(new MyNumber(1)).isEqualTo(new MyNumber("1"));
    }

    @Test
    public void plus() {
        MyNumber result = new MyNumber(1).plus(new MyNumber(2));
        assertThat(result).isEqualTo(new MyNumber(3));
    }

    @Test
    public void minus() {
        MyNumber result = new MyNumber(3).minus(new MyNumber(1));
        assertThat(result).isEqualTo(new MyNumber(2));
    }

    @Test
    public void multiply() {
        MyNumber result = new MyNumber(3).multiply(new MyNumber(2));
        assertThat(result).isEqualTo(new MyNumber(6));
    }

    @Test
    public void divide() {
        MyNumber result = new MyNumber(4).divide(new MyNumber(2));
        assertThat(result).isEqualTo(new MyNumber(2));
    }
}
