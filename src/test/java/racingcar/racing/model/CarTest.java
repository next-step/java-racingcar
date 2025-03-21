package racingcar.racing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("객체 생성 테스트")
    @Test
    public void createCar() {
        Car car = new Car("name");
        assertThat(car.getCarName())
                .isEqualTo("name");

        assertThat(car.getPosition())
                .isEqualTo(0);

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Car("abcdef"));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Car(""));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Car(null));
    }

    @DisplayName("move 테스트")
    @Test
    public void move() {
        Car car = new Car("name");

        assertThat(car.getPosition())
                .isEqualTo(0);

        car.move();
        assertThat(car.getPosition())
                .isEqualTo(1);

        for (int i = 0 ; i < 10 ; i++)
            car.move();

        assertThat(car.getPosition())
                .isEqualTo(11);
    }
}