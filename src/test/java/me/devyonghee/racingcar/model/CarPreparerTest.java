package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.model.sample.RandomEngineSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동자 준비자")
class CarPreparerTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> CarPreparer.of(CarFactory.of(1, RandomEngineSample.TEM_LIMIT_RANDOM_ENGINE), Distance.from(1)));
    }

    @Test
    @DisplayName("생산자와 초기 거리는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarPreparer.of(CarFactory.of(1, RandomEngineSample.TEM_LIMIT_RANDOM_ENGINE), null));
        assertThatIllegalArgumentException().isThrownBy(() -> CarPreparer.of(null, Distance.from(1)));
    }

    @Test
    @DisplayName("경주로들 준비")
    void tracks() {
        //given
        int count = 3;
        //when
        Tracks tracks = CarPreparer.of(CarFactory.of(count, RandomEngineSample.TEM_LIMIT_RANDOM_ENGINE), Distance.from(1)).tracks();
        //then
        assertThat(tracks.size()).isEqualTo(3);
    }
}
