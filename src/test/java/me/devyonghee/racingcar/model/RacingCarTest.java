package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("레이싱 자동차")
class RacingCarTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> RacingCar.from(Name.from("abc"), new MovementPolicy.Fake(true)));
    }

    @Test
    @DisplayName("이름과 엔진은 필수")
    void instance_nullEngine_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCar.from(Name.from("abc"), null));
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCar.from(null, new MovementPolicy.Fake(true)));
    }

    @ParameterizedTest
    @DisplayName("이동 정책에 대해서 이동 정보 반환")
    @CsvSource({"true,MOVE", "false,STOP"})
    void movement(boolean isMoved, Movement expected) {
        assertThat(RacingCar.from(Name.from("abc"), new MovementPolicy.Fake(isMoved)).movement()).isEqualTo(expected);
    }
}
