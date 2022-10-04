package com.game.racing.service;

import com.game.racing.domain.car.Cars;
import com.game.racing.domain.car.Winner;
import com.game.racing.domain.generator.MovableNumberGenerator;
import com.game.racing.domain.generator.NotMovableNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameServiceTest {

    private RacingGameService racingGameService;
    private final String[] carNames = new String[]{"pobi", "crong", "honux"};
    private final Integer tryCount = 5;

    @BeforeEach
    void set_up() {
        Winner.resetWinnerPositionValue();
    }

    @Test
    void play_racing_game() {
        racingGameService = new RacingGameService(carNames, tryCount);
        assertDoesNotThrow(() ->
                racingGameService.playRacingGame()
        );
    }

    @Test
    void play_racing_game_by_random_number_and_compare_winner_size() {
        racingGameService = new RacingGameService(carNames, tryCount);
        Cars cars = racingGameService.moveCarsByTryCountAndGetCars();
        assertThat(cars.getRacingWinners().size()).isLessThanOrEqualTo(cars.getTotalCarSize());
    }

    @Test
    void play_racing_game_by_movable_number_and_compare_winner_size() {
        racingGameService = new RacingGameService(carNames, tryCount, new MovableNumberGenerator());
        Cars cars = racingGameService.moveCarsByTryCountAndGetCars();
        assertThat(cars.getRacingWinners().size()).isEqualTo(cars.getTotalCarSize());
    }

    @Test
    void play_racing_game_by_not_movable_number_and_compare_winner_size() {
        racingGameService = new RacingGameService(carNames, tryCount, new NotMovableNumberGenerator());
        Cars cars = racingGameService.moveCarsByTryCountAndGetCars();
        assertThat(cars.getRacingWinners().size()).isEqualTo(cars.getTotalCarSize());
    }
}