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

}