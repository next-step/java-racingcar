package racingcar.racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("move 테스트")
    @Test
    public void move() {
        Car car = new Car();
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