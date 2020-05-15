package step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("입력값에 맞는 자동차 대수가 생성 되어야 한다.")
    public void createCarTest(int numberOfCar) {

        // when
        List<Car> cars = CarFactory.createCars(numberOfCar);

        // then
        assertThat(cars.size()).isEqualTo(numberOfCar);
    }
}
