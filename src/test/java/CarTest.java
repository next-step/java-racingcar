import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void generateCars() {
        Car car = new Car();
        car.advance();
        assertThat(car.getNumberOfAdvance())
                .isBetween(0, 9);
    }
}
