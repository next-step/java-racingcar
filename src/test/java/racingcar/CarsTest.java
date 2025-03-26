package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class CarsTest {

    @Test
    void 자동차_목록_생성_테스트() {
        Cars cars = Cars.ofQuantity(3);
        assertThat(cars.getCarsInfo()).hasSize(3);
    }

    @Test
    void 자동차수_음수_테스트() {
        assertThatThrownBy(() -> Cars.ofQuantity(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
