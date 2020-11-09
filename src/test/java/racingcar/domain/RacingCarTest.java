package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("RacingCar 생성 및 getName,getPlace 테스트")
    public void createRacingCar() {
        Car car = new RacingCar("bus", new RandomStrategy());

        assertThat(car.getName()).isEqualTo("bus");
        assertThat(car.getPlace()).isNotNull();
        assertThat(car.getPlace()).isEmpty();
    }
}