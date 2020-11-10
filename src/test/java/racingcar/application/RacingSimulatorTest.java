package racingcar.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.number.MovableNumberGenerator;
import racingcar.application.number.NotMovableNumberGenerator;
import racingcar.application.number.NumberGenerator;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingSimulatorTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        Car taxi = new Car("taxi", 0);
        Car damas = new Car("damas", 0);
        Car tesla = new Car("tesla", 0);
        cars.add(taxi);
        cars.add(damas);
        cars.add(tesla);
    }


    @Test
    @DisplayName("주어진 숫자가 4이상이면, 자동차의 이동거리를 1증가시킨다")
    public void should_move_cars() {
        //Given
        NumberGenerator movableNumberGenerator = new MovableNumberGenerator();
        RacingSimulator racingSimulator = new RacingSimulator(movableNumberGenerator);

        //When
        racingSimulator.moveCars(cars);

        //Then
        for (Car car : cars) {
            assertThat(car.getDistance()).isOne();
        }
    }

    @Test
    @DisplayName("주어진 숫자가 4미만이면, 자동차의 이동거리는 증가하지 않는다.")
    public void should_do_not_move_cars() {
        //Given
        NumberGenerator notMovableNumberGenerator = new NotMovableNumberGenerator();
        RacingSimulator racingSimulator = new RacingSimulator(notMovableNumberGenerator);

        //When
        racingSimulator.moveCars(cars);

        //Then
        for (Car car : cars) {
            assertThat(car.getDistance()).isZero();
        }
    }
}