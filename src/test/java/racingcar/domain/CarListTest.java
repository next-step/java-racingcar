package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarListTest {

    @Test
    @DisplayName("CarList 생성 테스트")
    void successCarListTest() {
        Car car = Car.from("name");
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        CarList carList = CarList.from(cars);

        assertThat(carList.getCarList().size()).isEqualTo(1);
    }

}