package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class CarsTest {

    @Test
    void 자동차_추가() {
        Cars cars = new Cars();
        cars.addCar(new Car());
        cars.addCar(new Car());
        assertThat(cars.count()).isEqualTo(2);
    }
}
