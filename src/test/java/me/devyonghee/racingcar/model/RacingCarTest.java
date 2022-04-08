package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("레이싱 자동차")
class RacingCarTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> RacingCar.from(RandomEngine.from(new Random(), 10)));
    }

    @Test
    @DisplayName("엔진은 필수")
    void instance_nullEngine_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCar.from(null));
    }

    @ParameterizedTest(name = "[{index}] 엔진 회전수가 {0} 이라면 자동차는 {1}")
    @DisplayName("엔진 회전수가 4이상인 경우에만 동작")
    @CsvSource({"3,STOP", "4,MOVE", "5,MOVE"})
    void move(int rotation, Movement expected) {
        //given
        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(rotation);
        //when, then
        assertThat(RacingCar.from(RandomEngine.from(random, 10)).movement()).isEqualTo(expected);
    }
}
