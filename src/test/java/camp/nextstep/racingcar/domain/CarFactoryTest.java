package camp.nextstep.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {

    @DisplayName("생성된 자동차 수 확인")
    @Test
    void countRacingCar() {
        int countOfCar = 3;
        List<Car> racingCars = CarFactory.of(countOfCar);
        assertThat(countOfCar).isEqualTo(racingCars.size());
    }

    @DisplayName("차량 갯수가 음수일 경우 예외 발생")
    @Test
    void negativeNumber_IllegalArgumentException() {
        int countOfCar = -1;
        assertThatThrownBy(() -> CarFactory.of(countOfCar))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("차량 갯수가 0일 경우 예외 발생")
    @Test
    void zero_IllegalArgumentException() {
        int countOfCar = 0;
        assertThatThrownBy(() -> CarFactory.of(countOfCar))
                .isInstanceOf(IllegalArgumentException.class);
    }
}