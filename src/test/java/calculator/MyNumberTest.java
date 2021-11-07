package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyNumberTest {
    @Test
    void create() {
        assertThat(new MyNumber("1")).isEqualTo(new MyNumber(1));
    }
}
