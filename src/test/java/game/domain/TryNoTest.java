package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNoTest {

    @Test
    @DisplayName("자연수가 아니라면")
    void not_natural_number() {
        assertThatThrownBy(() -> {
            new TryNo(0);
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            new TryNo(-1);
        }).isInstanceOf(RuntimeException.class);
    }
}