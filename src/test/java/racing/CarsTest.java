package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private static final int INITIAL_POSITION = 1;
    private Cars cars;

    @BeforeEach
    private void setup() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, INITIAL_POSITION));
        carList.add(new Car(2, INITIAL_POSITION));
        carList.add(new Car(3, INITIAL_POSITION));
        cars = new Cars(carList);
    }

    @DisplayName("자동차 수로 넣은 값으로 map size가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"2,2", "5,5", "7,7"}, delimiter = ',')
    void initCars(int carCount, int expected) {
        Cars initCars = Cars.initCars(carCount);
        assertThat(initCars.getCars()).hasSize(expected);
    }

    @DisplayName("random 값으로 만들어져서 0 또는 1의 값을 가진다.")
    @Test
    void moveCars() {
        cars.moveCars();
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isBetween(INITIAL_POSITION, INITIAL_POSITION + 1);
        }
    }
}