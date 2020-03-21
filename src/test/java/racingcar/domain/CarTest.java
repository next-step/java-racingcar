package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = Car.listOf(Arrays.asList("seul")).get(0);
        car.move(2);
    }

    @Test
    void move() {
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void printPosition() {
        car.move(1);
        car.printPosition();
    }
}
