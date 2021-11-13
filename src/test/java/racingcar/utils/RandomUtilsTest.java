package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomUtilsTest {

    @ParameterizedTest
    @DisplayName("랜덤 값이 10보다 작은 값인지 확인")
    @ValueSource(ints = 10)
    void randomValue(int bound) {
        assertThat(RandomUtils.nextInt()).isLessThan(bound);
    }

}
