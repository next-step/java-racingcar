package com.game.racing.play;

import com.game.racing.car.Cars;
import com.game.racing.generator.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void racing_game_play() {
        Integer carCount = 3;
        Integer tryCount = 5;
        assertThatNoException().isThrownBy(() -> {
            racingGame.play(carCount, tryCount);
        });
    }

    @Test
    void racing_game_move_cars_by_try_count() {
        Cars cars = new Cars(4, new RandomNumberGenerator());
        Integer tryCount = 5;
        assertThatNoException().isThrownBy(() -> {
            racingGame.moveCarsByTryCount(cars, tryCount);
        });
    }
}