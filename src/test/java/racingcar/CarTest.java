package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() throws Exception {
        Car car = new Car(() -> true);
        car.drive();
        assertThat(car.drivingDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() throws Exception {
        Car car = new Car(() -> false);
        car.drive();
        assertThat(car.drivingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void getResult() throws Exception {
        Car car = new Car(() -> true);
        car.drive();
        assertThat(car.getResult()).isEqualTo("-");
        car.drive();
        assertThat(car.getResult()).isEqualTo("--");
    }
}
