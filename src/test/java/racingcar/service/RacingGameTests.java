package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Board;
import racingcar.dto.RacingInfo;
import racingcar.model.Cars;
import racingcar.strategy.impl.RandomBoundMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTests {
    RacingInfo racingInfo;
    Cars cars;
    RacingGame racingGame;

    @BeforeEach
    void setup() {
        racingInfo = new RacingInfo(3, 5);
        cars = Cars.of(racingInfo.numberOfCar, new RandomBoundMovingStrategy());

        racingGame = new RacingGame(racingInfo, cars);
    }


    @Test
    @DisplayName("자동차 경주에서 주어진 횟수 만큼 경주내역이 기록되는지 확인")
    void racingHistoryCheckTest() {
        Board board = racingGame.gameStart();

        assertThat(board.getAllRecords().size()).isEqualTo(5);
    }

}
