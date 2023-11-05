package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("생성한 Car의 갯수만큼 Cars에 생성된 carList에 추가된다.")
    void createCars() {
        List<Car> carList = Arrays.asList(new Car(), new Car(), new Car());

        Cars cars = new Cars(carList);

        assertThat(cars.getCars()).hasSize(3);
    }
}