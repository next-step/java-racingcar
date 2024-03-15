package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private final MoveStrategy alwaysMoveStrategy = () -> true;
    private final Car carA = Car.from("testA");
    private final Car carB = Car.from("testB");
    private final Car carC = Car.from("testC");

    @Test
    void constructor() {
        Cars cars = getCars(carA, carB);

        assertThat(cars).hasSize(2);
    }

    @Test
    @DisplayName("내부의 모든 Car 중 가장 높은 Position 반환")
    void maxPosition() {
        moveCar(carA, 3);
        moveCar(carB, 2);
        moveCar(carC, 1);

        assertThat(getCars(carA, carB).maxPosition()).isEqualTo(3);
    }

    private void moveCar(Car car, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            car.play(alwaysMoveStrategy);
        }
    }

    private Cars getCars(Car... cars) {
        return Cars.from(List.of(cars));
    }

}