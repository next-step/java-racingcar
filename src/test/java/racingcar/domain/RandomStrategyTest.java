package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomStrategyTest {

    @Test
    void isMovableTrue() {
        MoveStrategy moveStrategy = () -> true;
        assertThat(moveStrategy.isMovable()).isTrue();
    }

    @Test
    void isMovableFalse() {
        MoveStrategy moveStrategy = () -> false;
        assertThat(moveStrategy.isMovable()).isFalse();
    }
}