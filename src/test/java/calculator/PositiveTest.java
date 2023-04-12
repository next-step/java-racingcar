package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveTest {
    @Test
    void create() {
        Positive positive = new Positive("3");
        assertThat(positive.isNumber(3))
                .isTrue();
    }
}
