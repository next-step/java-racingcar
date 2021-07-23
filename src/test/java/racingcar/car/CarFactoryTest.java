package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @DisplayName("사용자가 입력한 자동차 대수만큼 자동차를 생성한다.")
    @Test
    void create() {
        int numberOfCars = 5;
        List<Car> cars = CarFactory.create(numberOfCars);
        assertThat(cars).hasSize(5);
    }

}