package RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;
    @BeforeEach
    void setCar() {
        car = new Car();
    }
    @Test
    public void 전진_하는지() {
        car.setGoCar(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    public void 전진_안하는지() {
        car.setGoCar(1);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
