package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void testCarInitialPosition() {
        Car car = new Car("a", () -> true);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void testCarMoveCase() {
        Car car = new Car("a", () -> true);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void testCarUnMoveCase() {
        Car car = new Car("a", () -> false);
        car.move();
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void testCarNameLengthValidator() {
        String carName = "다섯글자초과";
        assertThatThrownBy(() -> new Car(carName, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
