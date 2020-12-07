package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void init() {
        int countOfCar = 3;
        racingCars = new RacingCars(countOfCar);
    }

    @Test
    @DisplayName("자동차 경주 참가 테스트")
    void participate_racing_test() {
        assertThat(racingCars.getParticipatingCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("참가한 자동차 레이싱 테스트")
    void racing_test() {
        // when
        racingCars.racing(() -> true);

        // then
        assertThat(racingCars.getParticipatingCars()).containsExactly(new RacingCar(1), new RacingCar(1), new RacingCar(1));
    }

}
