package edu.nextstep.racingcarwinner.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomRacingStrategyTest {

    @Test
    void movableTrue() {
        // given
        RandomRacingStrategy racingStrategy = new RandomRacingStrategy(){
            @Override
            public int getRandomNum() {
                return 4;
            }
        };

        // when
        boolean movable = racingStrategy.movable();

        // then
        assertTrue(movable);
    }

    @Test
    void movableFalse() {
        // given
        RandomRacingStrategy racingStrategy = new RandomRacingStrategy(){
            @Override
            public int getRandomNum() {
                return 3;
            }
        };

        // when
        boolean movable = racingStrategy.movable();

        // then
        assertFalse(movable);
    }
}