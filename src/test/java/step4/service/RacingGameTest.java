package step4.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.Cars;
import step4.domain.MustMoveStrategy;
import step4.dto.RacingGameCondition;
import step4.utils.CarNameSplitter;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"wani,pobi:1", "wani,pobi:2", "wani,pobi:3"}, delimiter = ':')
    @DisplayName("게임이 잘 되는지 확인한다.")
    void runGame(String carNames, int tryCount) {

        List<Integer> carsPositions = Collections.emptyList();
        RacingGame racingGame = new RacingGame(new RacingGameCondition(carNames, tryCount), new MustMoveStrategy());
        for (int i = 0; i < tryCount; i++) {
            Cars cars = racingGame.getGameRoundResult();
            carsPositions = cars.getCarsPosition();
        }
        carsPositions.forEach(carPosition -> assertThat(carPosition).isEqualTo(tryCount));


    }

    @ParameterizedTest
    @CsvSource(value = {"wani,pobi:1", "wani,pobi:2", "wani,pobi:3"}, delimiter = ':')
    @DisplayName("게임의 진행횟수를 확인한다.")
    void validGameTryCount(String carNames, int tryCount) {

        RacingGame racingGame = new RacingGame(new RacingGameCondition(carNames, tryCount), new MustMoveStrategy());
        assertThat(racingGame.getRacingGameTryCount()).isEqualTo(tryCount);

    }

    @ParameterizedTest
    @CsvSource(value = {"wani:1", "wani,pobi:2", "wani,pobi,jun:3"}, delimiter = ':')
    @DisplayName("게임을 위한 자동차 수가 맞는지 확인한다.")
    void validGameCarCount(String carNames, int carCount) {
        int tryCount = 1;
        RacingGame racingGame = new RacingGame(new RacingGameCondition(carNames, tryCount), new MustMoveStrategy());
        assertThat(CarNameSplitter.splitter(
                racingGame.getRacingGameCarNames()).length).isEqualTo(carCount);

    }
}