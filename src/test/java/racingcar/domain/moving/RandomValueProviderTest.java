package racingcar.domain.moving;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RandomValueProviderTest {
    @Test
    @DisplayName("랜덤범위값이 0보다 작은경우 예외를 발생시키는지 확인한다")
    void testIllegalArgumentException () {
        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    RandomValueProvider randomValueProvider = new RandomValueProvider(-1);
                    // then
                }).withMessageMatching("invalid random range");
    }
}
