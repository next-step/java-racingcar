package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("cars 초기화 테스트")
    void carsInitTest() {
        Count count = new Count(5);

        Cars cars = new Cars(count);

        assertThat(cars.getCarsSize()).isEqualTo(5);
    }

}
