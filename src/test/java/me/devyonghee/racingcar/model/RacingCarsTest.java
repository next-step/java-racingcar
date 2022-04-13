package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.model.sample.RacingCarSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("레이싱 자동차들")
class RacingCarsTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> RacingCars.from(
                Collections.singletonList(RacingCarSample.ONLY_MOVE_CAR)));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_emptyCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.from(null));
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.from(Collections.emptyList()));
    }
}
