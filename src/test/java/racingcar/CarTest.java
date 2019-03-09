package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 전진() {
        Car car = new Car();
        car.go();

        int movedDistance = car.getMovedDistance();
        assertThat(movedDistance).isEqualTo(1);
    }

    @Test
    public void 전진_성공() {
        Car car = new Car();
        int value = Car.MOVE_THRESHOLD + 1;

        car.goWhenGreaterThanThreshold(value);
        assertThat(car.getMovedDistance()).isEqualTo(1);
    }

    @Test
    public void 전진_실패() {
        Car car = new Car();
        int value = Car.MOVE_THRESHOLD - 1;

        car.goWhenGreaterThanThreshold(value);
        assertThat(car.getMovedDistance()).isEqualTo(0);
    }
}
