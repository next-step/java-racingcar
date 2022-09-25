package com.game.racing.play;

import com.game.racing.car.Cars;
import com.game.racing.generator.RandomIntegerGenerator;
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
    public void racingGame_playRacingGame() {
        Integer carCount = 3;
        Integer tryCount = 5;
        assertThatNoException().isThrownBy(() -> {
            racingGame.playRacingGame(carCount, tryCount);
        });
    }

    @Test
    public void racingGame_moveCarsByTryCount() {
        Cars cars = new Cars(4, new RandomIntegerGenerator());
        Integer tryCount = 5;
        assertThatNoException().isThrownBy(() -> {
            racingGame.moveCarsByTryCount(cars, tryCount);
        });
    }
}