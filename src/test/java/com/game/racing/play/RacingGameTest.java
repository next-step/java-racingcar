package com.game.racing.play;

import com.game.racing.car.Cars;
import com.game.racing.generator.RandomNumberGenerator;
import com.game.racing.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
        Position.resetMaxValue();
    }

    @Test
    void racing_game_play() {
        String carNames = "pobi,crong,honux";
        Integer tryCount = 5;
        assertThatNoException().isThrownBy(() -> {
            racingGame.play(carNames, tryCount);
        });
    }

    @Test
    void racing_game_play_naming_error() {
        String carNames = "pobi,crong,honux123";
        Integer tryCount = 5;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            racingGame.play(carNames, tryCount);
        });
    }

    @Test
    void racing_game_move_cars_by_try_count() {
        Cars cars = new Cars("pobi,crong,honux", new RandomNumberGenerator());
        Integer tryCount = 7;
        assertThatNoException().isThrownBy(() -> {
            racingGame.moveCarsByTryCount(cars, tryCount);
        });
    }
}