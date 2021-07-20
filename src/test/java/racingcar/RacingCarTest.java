package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("n대의 차 생성")
    void createcars(){
        int carCount = 3;
        List<Car> cars = racingCar.createCars(carCount);
        Assertions.assertThat(cars.size()).isEqualTo(carCount);
    }
}
