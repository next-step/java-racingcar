package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarMoverTest {

    @DisplayName("값이 4 이상이면 전진하고 3 이하면 전진하지 않는다")
    @ParameterizedTest(name = "값이 {0} 이면 위치는 {1}")
    @CsvSource({"4,1", "3,0"})
    void move(int number, int expected) {
        CarMover carMover = new CarMover();
        Car car = new Car();

        carMover.move(car, number);

        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
