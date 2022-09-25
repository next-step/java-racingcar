package service.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomStrategyTest {

    @Test
    void shouldMove_whenLargeOrEqual() {
        RandomStrategy strategyA = new RandomStrategy(() -> RandomStrategy.MIN_MOVE_NUMBER);

        assertThat(strategyA.isCarMove()).isTrue();

        RandomStrategy strategyB = new RandomStrategy(() -> RandomStrategy.MIN_MOVE_NUMBER + 1);

        assertThat(strategyB.isCarMove()).isTrue();
    }

    @Test
    void shouldNotMove_whenSmaller() {
        RandomStrategy strategy = new RandomStrategy(() -> RandomStrategy.MIN_MOVE_NUMBER - 1);

        assertThat(strategy.isCarMove()).isFalse();
    }

}
