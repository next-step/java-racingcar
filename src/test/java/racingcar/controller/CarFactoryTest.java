package racingcar.controller;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarFactory;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.dto.input.CarNames;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    private static final CarNames CAR_NAMES = new CarNames("damas,bmw,benz");
    private final CarFactory carFactory = new CarFactory();

    @Test
    @DisplayName("주어진 이름에 맞는 자동차들을 반환한다")
    void should_return_cars_by_names_of_cars() {
        //Given
        List<Car> expectedCars = Lists.newArrayList(
                new Car("damas"),
                new Car("bmw"),
                new Car("benz")
        );

        //When
        Cars cars = carFactory.createCars(CAR_NAMES);

        //Then
        assertThat(cars.getValue()).containsAll(expectedCars);
    }

    @Test
    @DisplayName("생성되지 않은 자동차의 이름은 반환하지 않는다")
    void should_not_return_cars_names() {
        //Given & When
        Cars cars = carFactory.createCars(CAR_NAMES);
        Car expectedCar = new Car("k5");

        //Then
        assertThat(cars.getValue()).isNotEmpty().doesNotContain(expectedCar);
    }

}
