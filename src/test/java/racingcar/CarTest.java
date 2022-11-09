package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    @DisplayName("car_생성_테스트")
    public void create_test() {
        Car car = new Car("java");
        assertThat(car).isNotNull();
    }
    @Test
    @DisplayName("car_동작_테스트")
    public void move_test() {
        Car car = new Car("java");
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
