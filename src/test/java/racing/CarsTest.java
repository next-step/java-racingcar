package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName(value = "참가할 자동차 목록을 생성한다.")
    @Test
    void createCars() {
        // given
        int participationCars = 3;

        // when
        Cars cars = new Cars(participationCars);

        // then
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }
}