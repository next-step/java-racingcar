package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("주어진 자동차 수 만큼 생성하는지 확인")
    void testCreateCars() {
        // given
        int count = 3;
        // when
        Cars cars = new Cars(3);
        // then
        assertThat(cars.size()).isEqualTo(count);
    }

    @Test
    @DisplayName("모든 자동차 전진")
    void testMoveAll() {
        // given
        Cars cars = new Cars(3);
        // when
        cars.moveAll(() -> true);
        // then
        cars.iterateCar(distance -> assertThat(distance).isEqualTo(1));
    }
}
