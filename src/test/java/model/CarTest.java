package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void testCarInitialPosition() {
        Car car = new Car("a");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void testCarMoveCase() {
        Car car = new Car("a");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void testCarUnMoveCase() {
        Car car = new Car("a");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void testCarNameLengthValidator() {
        String carName = "다섯글자초과";
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
