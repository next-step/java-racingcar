package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {


    @Test
    @DisplayName("4이상의 숫자가 전달되면 한번 전진한다.")
    void 움직임_테스트() {
        Car car = new Car();

        car.move(5);
        assertThat(car.checkPosition(1)).isTrue();
    }

    @Test
    @DisplayName("3이하 숫자가 전달되면 한번 전진한다.")
    void 멈춤_테스트() {
        Car car = new Car();

        car.move(0);
        assertThat(car.checkPosition(0)).isTrue();

        car.move(1);
        assertThat(car.checkPosition(0)).isTrue();
    }

    @Test
    @DisplayName("0~9 사이의 숫자가 아니라면 예외발생")
    void 움직임_숫자범위예외발생_테스트() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.move(10);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            car.move(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

