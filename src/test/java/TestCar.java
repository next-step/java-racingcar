import CarRacing.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCar {

    Car car;
    @BeforeEach
    public void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("차량 생성 시 초기 위치는 1")
    public void car_initial_position() {
        int expected = 1;

        int actual = car.current();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("차량 이동 시 현재 위치에 입력된 수만큼 더해진다")
    public void car_move() {
        int input = 3;
        int expected = 4;

        car.move(input);
        int actual = car.current();
        assertThat(actual).isEqualTo(expected);
    }
}
