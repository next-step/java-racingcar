package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 자동차 스코어 관련")
class RacingScoreTest {

    @DisplayName("자동차 레이싱 이동 결과를 - 로 변환한다.")
    @Test
    void racing_convert() {

        final RacingCar racingCar = RacingCar.init();
        racingCar.move();
        final RacingCars racingCars = RacingCars.from(racingCar);
        final RacingScore racingScore = RacingScore.getInstance();
        racingScore.save(racingCars);

        assertThat(racingScore.score().get(0)).contains("-");
    }
}
