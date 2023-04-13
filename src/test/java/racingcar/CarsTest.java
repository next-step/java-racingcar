package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 객체 3개 생성")
    @ValueSource(ints = {3})
    void addCars_inputNumberCarsSize(int number) {
        Cars cars = new Cars(number);
        assertThat(cars.size()).isEqualTo(number);
    }

}
