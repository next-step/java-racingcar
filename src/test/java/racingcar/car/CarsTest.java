package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 리스트 테스트")
class CarsTest {

    @DisplayName("자동차 리스트를 초기화 하는데는 차의 수, MoveStrategy 가 필요하다.")
    @Test
    void initCars() {
        assertThat(new Cars(10, () -> true)).isNotNull();
    }

}