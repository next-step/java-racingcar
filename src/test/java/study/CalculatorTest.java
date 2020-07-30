package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void claculatorTest() {
        assertThat((2 + 3) * 4 / 2).isEqualTo(10);
    }
}
