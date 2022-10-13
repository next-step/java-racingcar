package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void car_수() {
        Cars cars = new Cars(2, 0);
        assertThat(cars.getCarListSize()).isEqualTo(2);
    }
}