package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialNumTest {
    @Test
    void test_negative_number() {
        assertThatThrownBy(() -> new TrialNum(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
