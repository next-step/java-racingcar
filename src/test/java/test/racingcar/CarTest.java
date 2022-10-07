package test.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void moveTest() {
        Car car = new Car();
        car.moveForward();
        assertThat(car).isEqualTo(new Car(1));
    }

    @Test
    @DisplayName("자동차 전진 시각화")
    void displayMoveTest() {
        Car car = new Car(5);
        car.moveForward();
        assertThat(car).isEqualTo(new Car(6));
        assertThat(car.printMovedDistance()).isEqualTo("------");
    }
}
