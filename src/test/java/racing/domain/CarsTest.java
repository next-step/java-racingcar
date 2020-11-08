package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차를 10대 생성하여 생성된 자동차 수 확인")
    void 자동차_대수_확인() {
        //given
        Cars cars = new Cars();

        // when
        cars.setCars(10);

        // then
        assertThat(cars.getCars().size()).isEqualTo(10);
    }

}
