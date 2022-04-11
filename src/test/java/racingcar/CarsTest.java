package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints =  {1, 2, 3})
    @DisplayName("input 수 만큼의 Car 리스트 생성")
    void generateCarList(int input) {
        Cars cars = Cars.generateCars(input);
        assertThat(cars.get()).hasSize(input);
    }

}