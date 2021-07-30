package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    Cars cars = new Cars();

    @BeforeEach
    void setting() {
        cars.prepareCars(new String[]{"test1","test2","test3"});
    }

    @Test
    @DisplayName("cars max Distance Test")
    void carsMaxDistanceTest() {
        cars.carsMove();
        assertThat(cars.getMaxDistance()).isGreaterThan(0);
    }
}
