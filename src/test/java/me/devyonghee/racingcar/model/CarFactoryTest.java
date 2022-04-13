package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 공장")
class CarFactoryTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> CarFactory.of(NameWriter.from("abc"), () -> Movement.MOVE));
    }

    @Test
    @DisplayName("작명가와 사용할 엔진은 필수")
    void instance_nullEngine_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarFactory.of(NameWriter.from("abc"), null));
        assertThatIllegalArgumentException().isThrownBy(() -> CarFactory.of(null, () -> Movement.MOVE));
    }

    @Test
    @DisplayName("주어진 이름대로 자동차들 생성")
    void cars() {
        //given, when
        RacingCars cars = CarFactory.of(NameWriter.from("abc,123"), () -> Movement.MOVE).cars();
        //then
        assertThat(cars.size()).isEqualTo(2);
    }
}
