package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameLogTest {

    @DisplayName("자동차 경주 로그 저장 테스트")
    @Test
    void record() {
        // given
        RacingCars racingCars = new RacingCars(List.of(new RacingCar("woody"), new RacingCar("jacob")));

        // when
        RacingGameLog racingGameLog = new RacingGameLog(racingCars);

        // then
        assertThat(racingGameLog.getRacingCars()).isEqualTo(racingCars);
    }
}
