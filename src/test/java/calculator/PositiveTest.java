package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveTest {

    @Test
    void 캡슐화() {
        Positive positive = new Positive("3");
        assertThat(positive.getNumber()).isEqualTo(3);
    }
}
