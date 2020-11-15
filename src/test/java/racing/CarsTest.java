package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CarsTest {

    @DisplayName(value = "참가할 자동차 목록을 생성한다.")
    @Test
    void createCars() {
        // given
        int participationCars = 3;
        List<Integer> oldPositions = new ArrayList<>();
        oldPositions.add(0);
        oldPositions.add(0);
        oldPositions.add(0);

        // when
        Cars cars = new Cars(participationCars, oldPositions);

        // then
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }
}