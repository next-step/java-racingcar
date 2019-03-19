package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void move() {
        Car car = new Car("test1", 0);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void checkMove() {
        Car car = new Car("test", 0);
        boolean result = car.checkMove(3);
        assertThat(result).isFalse();
        result = car.checkMove(4);
        assertThat(result).isTrue();
    }

    @Test
    public void isMaxPosition() {
        Car car = new Car("test", 1);
        int result = car.isMaxPosition(2);
        assertThat(result).isEqualTo(-1);
        result = car.isMaxPosition(1);
        assertThat(result).isEqualTo(1);
    }
}