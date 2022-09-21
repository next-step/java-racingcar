package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarListTest {

    @DisplayName("자동차 경주 리스트를 초기화한다")
    @Test
    void initialize() {
        RacingCarList racingCars = RacingCarList.initialize(3);

        assertThat(racingCars.currentRacingCars().size()).isEqualTo(3);
        assertThat(racingCars.currentRacingCars().get(0).currentPosition()).isEqualTo(0);
    }

    @DisplayName("다음 자동차 경주 리스트를 반환한다")
    @Test
    void next() {
        RacingCarList racingCars = RacingCarList.initialize(3);

        RacingCarList nextRacingCars = racingCars.next();

        assertThat(nextRacingCars.currentRacingCars().size()).isEqualTo(3);
    }
}