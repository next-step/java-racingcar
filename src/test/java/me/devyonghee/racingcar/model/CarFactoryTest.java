package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.model.sample.RandomEngineSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 공장")
class CarFactoryTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> CarFactory.of(1, RandomEngineSample.TEM_LIMIT_RANDOM_ENGINE));
    }

    @Test
    @DisplayName("자동차 대수는 0이상")
    void instance_negativeCarCount_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarFactory.of(-1, RandomEngineSample.TEM_LIMIT_RANDOM_ENGINE));
    }

    @Test
    @DisplayName("사용할 엔진은 필수")
    void instance_nullEngine_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarFactory.of(1, null));
    }

    @Test
    @DisplayName("자동차들 생성")
    void cars() {
        //given
        int count = 1;
        //when
        RacingCars cars = CarFactory.of(count, RandomEngineSample.TEM_LIMIT_RANDOM_ENGINE).cars();
        //then
        assertThat(cars.size()).isEqualTo(count);
    }
}
