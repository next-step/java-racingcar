package service.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomStrategyTest {

    private RandomStrategy strategy = new RandomStrategy();

    @Test
    void shouldMove_whenLargeOrEqual(){
        boolean resultA = strategy.isCarMove(RandomStrategy.MIN_MOVE_NUMBER);
        assertThat(resultA).isTrue();
        boolean resultB = strategy.isCarMove(RandomStrategy.MIN_MOVE_NUMBER + 1);
        assertThat(resultB).isTrue();
    }

    @Test
    void shouldNotMove_whenSmaller(){
        boolean result = strategy.isCarMove(RandomStrategy.MIN_MOVE_NUMBER-1);
        assertThat(result).isFalse();
    }

}