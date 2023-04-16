package racingcar.v1.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("a", 10);
    }

    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo("a");
    }

    @Test
    void getDistance() {
        assertThat(car.getDistance()).isEqualTo(10);
    }

    @Test
    void addDistance() {
        car.addDistance(5);
        assertThat(car.getDistance()).isEqualTo(15);
    }
}