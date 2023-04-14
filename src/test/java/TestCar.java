import CarRacing.Car;
import CarRacing.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCar {

    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("차량 생성 시 초기 위치는 1")
    public void car_initial_position() {
        int expected = 1;

        int actual = car.currentPosition();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("차량 이동 시 현재 위치에 입력된 수만큼 더해진다")
    public void car_move() {
        int input = 3;
        int expected = 4;

        car.move(input);
        int actual = car.currentPosition();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("차량 생성 시 이름을 입력받는다")
    public void car_name() {
        String expected = "pobi";

        String actual = car.getName();
        assertThat(actual).isEqualTo(expected);
    }
}
