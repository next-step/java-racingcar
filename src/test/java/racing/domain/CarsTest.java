package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차 개수 확인")
    void getCarCount() {
        String[] names = {"pobi","crong","honux"};
        Cars cars = new Cars(String.join(",", names));
        assertThat(cars.getCarCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름 확인")
    void getCarNames() {
        String[] names = {"pobi","crong","honux"};
        Cars cars = new Cars(String.join(",", names));
        assertThat(cars.getCarNames()).isEqualTo(names);
    }

    @Test
    @DisplayName("최대 이동 거리")
    void getMaxMovedDistance() {
        String[] names = {"pobi","crong","honux"};
        Cars cars = new Cars(String.join(",", names));
        assertThat(cars.getMaxMovedDistance()).isEqualTo(0);
    }
}
