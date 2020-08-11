package CarRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("INPUT값만큼 차가 생성되었는지")
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void makeCar(int count) {
        int expectValue = count;
        Cars cars = new Cars(count);
        assertThat(cars.carList().size()).isEqualTo(expectValue);
    }
}
