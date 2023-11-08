package carracing;

import carracing.domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    private static final String CAR_NAME = "Car1";

    @Test
    @DisplayName("생성/자동차 생성/생성된다.")
    void createCar() {
        Car car = new Car(CAR_NAME);
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("이동/자동차가 이동/위치가 변경된다.")
    void moveCar() {
        // given
        Car car = new Car(CAR_NAME);

        // when
        car.move(4);

        // then
        assertThat(car.getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("위치동일여부/자동차의 위치가 동일/true")
    void isSamePosition() {
        // given
        Car car = new Car(CAR_NAME, 5);

        // when // then
        assertTrue(car.isSamePosition(new Car(CAR_NAME, 5)));
    }
}
