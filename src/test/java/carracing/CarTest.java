package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("생성/자동차 생성/생성된다.")
    void createCar() {
        Car car = new Car("Car1");
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("이동/자동차가 이동/위치가 변경된다.")
    void moveCar() {
        // given
        Car car = new Car("Car1");

        // when
        car.move(4);

        // then
        assertThat(car.getPosition()).isEqualTo(5);
    }
}
