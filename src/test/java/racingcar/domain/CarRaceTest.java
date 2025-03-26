package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    @Test
    @DisplayName("자동차 경주 게임을 한번 실행했을 때, 자동차가 한 번 전진한다.")
    void runOnce() {
        int runCount = 1;
        Cars cars = Cars.from(List.of("luna"));
        MoveStrategy moveStrategy = new MoveStrategy(() -> 4);

        CarRace carRace = new CarRace(cars, runCount, moveStrategy);
        List<List<CarState>> results = carRace.run();

        assertThat(results).hasSize(runCount);
    }

}
