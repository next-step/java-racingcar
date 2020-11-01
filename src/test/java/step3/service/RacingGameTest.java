package step3.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Cars;
import step3.domain.MustMoveStrategy;
import step3.dto.RacingGameCondition;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("게임이 잘 되는지 확인한다.")
    void runGame(int carCount, int tryCount) {

        List<Integer> carsPositions = Collections.emptyList();
        RacingGame racingGame = new RacingGame(new RacingGameCondition(carCount, tryCount), new MustMoveStrategy());
        for (int i = 0; i < tryCount; i++) {
            Cars cars = racingGame.getGameRoundResult();
            carsPositions = cars.getCarsPosition();
        }
        carsPositions.forEach(carPosition -> assertThat(carPosition).isEqualTo(tryCount));


    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("게임의 진행횟수를 확인한다.")
    void validGameTryCount(int carCount, int tryCount) {

        RacingGame racingGame = new RacingGame(new RacingGameCondition(carCount, tryCount), new MustMoveStrategy());
        assertThat(racingGame.getRacingGameTryCount()).isEqualTo(tryCount);

    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("게임을 위한 자동차 갯수가 맞는지 확인한다.")
    void validGameCarCount(int carCount, int tryCount) {

        RacingGame racingGame = new RacingGame(new RacingGameCondition(carCount, tryCount), new MustMoveStrategy());
        assertThat(racingGame.getGameRoundResult()
                .getCarsPosition()
                .size()).isEqualTo(tryCount);

    }
}