package com.mommoo.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    private static final int COUNT_OF_CAR = 3;

    private RacingGame racingGame;

    @BeforeEach
    public void createInstance() {
        racingGame = new RacingGame(COUNT_OF_CAR);
    }

    @ParameterizedTest
    @ValueSource(ints={1, 2, 3})
    public void testMove(int time) {
        int[] result = racingGame.move();
        for (int move : result) {
            assertThat(move).isLessThan(time + 1);
        }
    }
}
