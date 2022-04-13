package camp.nextstep.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @DisplayName("자동차 경주 결과 기록 비교")
    @Test
    void start() {
        RacingCarGameInputData inputData = new RacingCarGameInputData(3, 5);
        List<Car> racingCars = CarFactory.of(inputData.getCountOfCar());
        RacingCarGame racingCarGame = new RacingCarGame(inputData.getRounds(), racingCars, new RandomMoveCondition(new DefaultRandomGenerator()));
        List<RacingCarGameRecord> racingCarGameRecords = racingCarGame.start();

        assertThat(inputData.getRounds()).isEqualTo(racingCarGameRecords.size());
        for (RacingCarGameRecord racingCarGameRecord : racingCarGameRecords) {
            assertThat(inputData.getCountOfCar()).isEqualTo(racingCarGameRecord.getCarRecords().size());
        }

    }
}