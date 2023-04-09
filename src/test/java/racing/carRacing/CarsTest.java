package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("cars 초기화 테스트")
    void carsInitTest() {
        Count count = new Count(5);
        Cars cars = new Cars();
        List<Car> resultList = cars.initCars(count);

        assertThat(resultList).hasSize(5);
    }
}