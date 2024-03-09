package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    public static final String NAME = "name";

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() {
        Car car = new Car(NAME);
        car.drive(() -> true);
        assertThat(car.drivingDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() {
        Car car = new Car(NAME);
        car.drive(() -> false);
        assertThat(car.drivingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void result() {
        Car car = new Car(NAME);
        car.drive(() -> true);
        assertThat(car.result()).isEqualTo(NAME + " : -");
        car.drive(() -> true);
        assertThat(car.result()).isEqualTo(NAME + " : --");
    }
}
