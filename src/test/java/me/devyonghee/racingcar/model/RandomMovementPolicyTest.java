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

@DisplayName("랜덤 이동 정책")
class RandomMovementPolicyTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> RandomMovementPolicy.from(new Random()));
    }

    @Test
    @DisplayName("랜덤 객체는 필수")
    void instance_nullRandom_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RandomMovementPolicy.from(null));
    }

    @ParameterizedTest(name = "[{index}] 랜덤한 수가 {0} 이라면 이동은 {1}")
    @DisplayName("랜덤한 숫자가 4이상이면 이동")
    @CsvSource({"3,STOP", "4,MOVE", "5,MOVE"})
    void movement(int randomNumber, Movement expected) {
        //given
        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(randomNumber);
        //when, then
        assertThat(RandomMovementPolicy.from(random).movement()).isEqualTo(expected);
    }
}
