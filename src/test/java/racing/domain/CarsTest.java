package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("자동차가 입력받은 댓수만큼 생긴다")
    void createCars() {
        Cars cars = Cars.create(5);
        assertThat(cars.getCars().size()).isEqualTo(5);
    }
}
