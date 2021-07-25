package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.Board;
import racingcar.dto.RacingInfo;
import racingcar.model.Cars;
import racingcar.strategy.impl.RandomBoundMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTests {

    @DisplayName("자동차 경주에서 주어진 횟수 만큼 경주내역이 기록되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void racingHistoryCheckTest(int raceTrialCount) {
        RacingInfo racingInfo = new RacingInfo(3, raceTrialCount);

        Cars cars = Cars.of(racingInfo.numberOfCar);

        RacingGame racingGame = new RacingGame(racingInfo, cars);

        Board board = racingGame.gameStart(new RandomBoundMovingStrategy());

        assertThat(board.getAllRecords().size()).isEqualTo(raceTrialCount);
    }

    @DisplayName("자동차 경주에서 주어진 자동차 대수 만큼 경주하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void racingCarsCountCheckTest(int numberOfCar) {
        RacingInfo racingInfo = new RacingInfo(numberOfCar, 1);

        Cars cars = Cars.of(racingInfo.numberOfCar);

        RacingGame racingGame = new RacingGame(racingInfo, cars);

        Board board = racingGame.gameStart(new RandomBoundMovingStrategy());

        assertThat(board.getAllRecords().get(0).size()).isEqualTo(numberOfCar);

    }


}
