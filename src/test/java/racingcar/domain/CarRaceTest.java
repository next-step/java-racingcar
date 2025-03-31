package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    @Test
    @DisplayName("자동차 경주 게임을 한번 실행했을 때, 자동차가 한 번 전진한다.")
    void runOnce() {
        CarRace carRace = new CarRace(List.of("luna"), 1, new MoveStrategy(() -> 4));
        carRace.run();

        assertThat(carRace.getRemainRunCount()).isZero();
    }

}
