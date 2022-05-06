package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @Test
    @DisplayName("RacingCars 객체를 만든다.")
    void create_racing_cars() {
        RacingCars rc = RacingCars.create(3);
        assertThat(rc.getValue().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("RacingCars 객체를 만들 때 0 이하의 수를 입력하면 예외가 발생한다.")
    void create_racing_cars_negative() throws Exception {
        assertThatThrownBy(() -> RacingCars.create(0))
                .isInstanceOf(RuntimeException.class);
    }
}
