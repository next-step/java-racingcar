package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int INITIAL_POSITION = 1;
    private ArrayList<Car> cars;

    @BeforeEach
    private void beforEach() {
        cars = new ArrayList<>();
        cars.add(new Car(1, INITIAL_POSITION));
        cars.add(new Car(2, INITIAL_POSITION));
        cars.add(new Car(3, INITIAL_POSITION));
    }

    @DisplayName("자동차 수로 넣은 값으로 map size가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"2,2", "5,5", "7,7"}, delimiter = ',')
    void initCars(int carCount, int expected) {
        assertThat(Car.initCars(carCount)).hasSize(expected);
    }

    @DisplayName("random 값으로 만들어져서 0 또는 1의 값을 가진다.")
    @Test
    void moveCars() {
        Car.moveCars(cars);
        for (Car car : cars) {
            assertThat(car.getPosition()).isBetween(INITIAL_POSITION, INITIAL_POSITION + 1);
        }
    }
}