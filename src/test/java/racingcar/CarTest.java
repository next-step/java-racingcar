package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private static final String CAR_NAME = "name";
    private static final DrivingStrategy ALWAYS_MOVE = () -> true;
    private static final DrivingStrategy NEVER_MOVE = () -> false;

    private final Car car = new Car(CAR_NAME);

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() {
        car.drive(ALWAYS_MOVE);
        assertThat(car.drivingDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() {
        car.drive(NEVER_MOVE);
        assertThat(car.drivingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void result() {
        car.drive(ALWAYS_MOVE);
        assertThat(car.result()).isEqualTo(CAR_NAME + " : -");
        car.drive(ALWAYS_MOVE);
        assertThat(car.result()).isEqualTo(CAR_NAME + " : --");
    }
}
