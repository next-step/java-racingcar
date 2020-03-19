package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @Test
    void move() {
        int position = car.move();

        assertThat(position).isGreaterThan(-1);
    }
}
