package racingcar.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private String carName = "pobi";

    @Test
    public void 자동차_생성_후_이름_확인() {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    public void 전진_성공() {
        Car car = new Car(carName);
        int value = Car.MOVE_THRESHOLD + 1;

        car.goWhenGreaterThanThreshold(value);
        assertThat(car.getMovedDistance()).isEqualTo(1);
    }

    @Test
    public void 전진_실패() {
        Car car = new Car(carName);
        int value = Car.MOVE_THRESHOLD;

        car.goWhenGreaterThanThreshold(value);
        assertThat(car.getMovedDistance()).isEqualTo(0);
    }

    @Test
    public void copy_생성() {
        Car car = new Car(carName);
        int value = Car.MOVE_THRESHOLD + 1;

        car.goWhenGreaterThanThreshold(value);
        Car copy = car.copy();

        assertThat(copy.getName()).isEqualTo(carName);
        assertThat(copy.getMovedDistance()).isEqualTo(1);

        car.goWhenGreaterThanThreshold(value);
        assertThat(copy.getMovedDistance()).isEqualTo(1);
    }
}