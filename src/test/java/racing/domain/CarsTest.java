package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차가 입력받은 댓수만큼 생긴다")
    void createCars() {
        String[] names = new String[]{"pobi", "crong", "honux"};
        Cars cars = Cars.create(names);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}
