package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRaceTest {

    @Test
    @DisplayName("자동차 경주 게임을 한번 실행했을 때, 자동차가 한 번 전진한다.")
    void run() {
        CarRace carRace = new CarRace(List.of("luna"), 1, new MoveStrategy(() -> 4));
        carRace.run();

        assertThat(carRace.getRemainRunCount()).isZero();
    }

    @Test
    @DisplayName("자동차 경주 게임 진행중에 우승자를 조회하면, 에러가 발생한다.")
    void failToFindWinners() {
        CarRace carRace = new CarRace(List.of("luna"), 1, new MoveStrategy(() -> 4));
        assertThatThrownBy(carRace::findWinners)
                .isInstanceOf(UnsupportedOperationException.class);
    }

}
