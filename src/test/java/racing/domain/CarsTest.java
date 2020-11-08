package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("자동차 이름이 5자 초과하여 넘어갈 경우 exception 발생 테스트")
    void 자동차_이름_유효성검사_테스트() {
        assertThatThrownBy(() ->
            new Cars().setCars("테스트자동차")
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
