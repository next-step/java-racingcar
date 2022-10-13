package racinggame.domain.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @Test
    void 이동() {
        MoveStrategy strategy = new RandomMoveStrategy((randomNumber) -> 4);
        assertThat(strategy.movable()).isTrue();
    }

    @Test
    void 이동불가() {
        MoveStrategy strategy = new RandomMoveStrategy((randomNumber) -> 3);
        assertThat(strategy.movable()).isFalse();
    }
}