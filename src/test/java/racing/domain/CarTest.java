package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    public void moveTest() {
        final int possibleMovingDistance = 4;
        car.run(possibleMovingDistance);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void stopTest() {
        final int possibleMovingDistance = 3;
        car.run(possibleMovingDistance);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}