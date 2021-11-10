package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovableTest {
    @Test
    void 조건_PASS() {
        MovePredicate movePredicate = () -> true;
        assertThat(movePredicate.test()).isTrue();
    }

    @Test
    void 조건_FAIL() {
        MovePredicate movePredicate = () -> false;
        assertThat(movePredicate.test()).isFalse();
    }
}
