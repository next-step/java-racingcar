package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyNumberTest {
    @Test
    void create(){
        assertThat(new MyNumber("1")).isEqualTo(new MyNumber((1)));
    }

    @Test
    void plus(){
        MyNumber result = new MyNumber("1").plus(new MyNumber(2));
        assertThat(result).isEqualTo(3);
    }
}
