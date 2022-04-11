package me.devyonghee.racingcar.model;

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
        assertThatNoException().isThrownBy(() -> RacingCars.from(Collections.emptyList()));
        assertThatNoException().isThrownBy(() -> RacingCars.from(
                Collections.singletonList(RacingCar.from(new MovementPolicy.Fake(true)))));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_nullCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.from(null));
    }
}
