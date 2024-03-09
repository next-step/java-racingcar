package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private static final String CAR_NAME = "name";

    private final Car car = new Car(CAR_NAME);

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() {
        car.drive(() -> true);
        assertThat(car.drivingDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() {
        car.drive(() -> false);
        assertThat(car.drivingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void result() {
        car.drive(() -> true);
        assertThat(car.result()).isEqualTo(CAR_NAME + " : -");
        car.drive(() -> true);
        assertThat(car.result()).isEqualTo(CAR_NAME + " : --");
    }
}
