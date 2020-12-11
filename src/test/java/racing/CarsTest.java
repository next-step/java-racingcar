package racing;

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
        // when
        assertThat(cars.size()).isEqualTo(count);
    }
}
