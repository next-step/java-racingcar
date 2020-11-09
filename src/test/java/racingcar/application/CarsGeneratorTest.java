package racingcar.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarsGeneratorTest {

    CarsGenerator carsGenerator;

    @BeforeEach
    public void setUp() {
        carsGenerator = new CarsGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = 5)
    @DisplayName("주어진 수만큼 자동차 배열을 생성한다.")
    public void should_create_cars(int countOfCar) {
        Car[] cars = carsGenerator.generateCars(countOfCar);
        assertThat(cars.length).isEqualTo(countOfCar);
    }

}