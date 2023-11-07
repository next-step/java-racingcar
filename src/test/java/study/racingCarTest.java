package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;


public class racingCarTest {

    @DisplayName("랜덤 값이 4이상일 때 한칸 전진한다.")
    @Test
    void moveCar() {
        Car car = new Car();
        car.forwardOneStep(car.canMove(4));
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 4미만일 때 움직이지 않는다.")
    @Test
    void stopCar() {
        Car car = new Car();
        car.forwardOneStep(car.canMove(3));
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("3번의 횟수동안 올바르게 움직이는지 테스트 해본다.")
    @Test
    void testCar() {
        Car car = new Car();

        car.forwardOneStep(car.canMove(3));
        assertThat(car.getPosition()).isEqualTo(0);

        car.forwardOneStep(car.canMove(4));
        assertThat(car.getPosition()).isEqualTo(1);

        car.forwardOneStep(car.canMove(9));
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
