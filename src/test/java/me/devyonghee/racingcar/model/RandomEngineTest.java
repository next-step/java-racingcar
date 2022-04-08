package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

@DisplayName("랜덤 엔진")
class RandomEngineTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> RandomEngine.from(new Random(), 1));
    }

    @Test
    @DisplayName("랜덤 객체는 필수")
    void instance_nullRandom_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RandomEngine.from(null, 1));
    }

    @Test
    @DisplayName("한도는 반드시 양수")
    void instance_notPositiveLimit_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RandomEngine.from(new Random(), 0));
    }

    @Test
    @DisplayName("회전 수는 주어진 한도보다 항상 낮음")
    void rotationCount() {
        //given
        int limit = 10;
        RandomEngine engineWithLimit = RandomEngine.from(new Random(), limit);
        //when, then
        assertThat(engineWithLimit.rotationCount()).isLessThan(limit);
    }
}
