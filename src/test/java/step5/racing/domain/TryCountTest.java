package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void 시도할_회수가_0보다_작을_때_예외가_발생한다() {
        assertThatThrownBy(() -> new TryCount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
