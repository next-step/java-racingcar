package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {


    @Test
    @DisplayName("참가 자동차 수 테스트")
    public void createRacingCarsTest() {

        int carCount = 5;
        RacingCars sut = new RacingCars(carCount);

        assertThat(sut.numberOfParticipants()).isEqualTo(carCount);
    }

    @Test
    @DisplayName("moveCar 매개변수가 4이상이면 자동차가 전진한다")
    public void moveCarTest() {
        RacingCars sut = new RacingCars(5);
        sut.moveCar(() -> 5);

        for (Car racingCar : sut.getRacingCars()) {
            assertThat(racingCar.position()).isEqualTo(1);
        }
    }


}