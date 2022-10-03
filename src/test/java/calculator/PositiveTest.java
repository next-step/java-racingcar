package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveTest {
    @Test
    void test_positive_number() {
        assertThat(new Positive("1")).isEqualTo(new Positive("1"));
    }

    @Test
    void test_plus() {
        Positive result = new Positive("1").plus(2);
        assertThat(result).isEqualTo(new Positive(3));
    }

    @Test
    void test_negative_number() {
        assertThatThrownBy(() -> new Positive("-1")).isInstanceOf(RuntimeException.class);
    }
}
