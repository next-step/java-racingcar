package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void init_테스트() {
        Cars cars = new Cars(5);
        assertThat(cars.cars).hasSize(5);
    }
}