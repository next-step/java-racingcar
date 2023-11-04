package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("성공 - 자동차 대수 만큼 position 값이 0인 자동차를 생성한다.")
    void success_generate_cars() {
        //given
        int carSize = 3;

        //when & then
        assertThat(new Cars(carSize).getCar()).hasSize(carSize)
                .extracting("position")
                .containsOnly(0, 0, 0);
    }

}
