package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @DisplayName("입력 값만큼 자동차를 생성")
    @ValueSource(ints = {1,5,10,100})
    @ParameterizedTest
    void createCarList(int expected) {
        List<Car> carList = Collections.nCopies(expected, new Car("name"));
        Cars cars = Cars.from(carList);
        assertThat(cars.numberOfCar()).isEqualTo(expected);
    }

}
