package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;


import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {

        car = new Car(0);
    }

    @Test
    void testMove() {
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(1);

    }

}
