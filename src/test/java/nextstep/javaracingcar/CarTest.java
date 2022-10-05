package nextstep.javaracingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car 는 주어진 이동 거리 만큼 한번에 이동할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10})
    public void spec01(final int movableDistance) {
        final String carName = "TEST_CAR";
        final Car car = new Car(carName, () -> PositiveNumber.from(movableDistance));
        car.move();
        assertThat(car.dashboard()).isEqualTo(new CarDashboard(carName, PositiveNumber.from(movableDistance)));
    }

    @DisplayName("Car 는 주어진 이동할 때 마다 주어진 거리만큼 이동한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10})
    public void spec02(final int moveCount) {
        final String carName = "TEST_CAR";
        final CarEngine oneDistanceSupplier = () -> PositiveNumber.from(1);
        final Car car = new Car(carName, oneDistanceSupplier);
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        assertThat(car.dashboard()).isEqualTo(new CarDashboard(carName,PositiveNumber.from(moveCount)));
    }
}
