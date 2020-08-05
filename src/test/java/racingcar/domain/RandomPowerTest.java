package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomPowerTest {

    @DisplayName("랜덤값 범위 검증")
    @RepeatedTest(100)
    void makeRandomIntValue() {
        assertThat(RandomPower.nextInt())
                .isGreaterThanOrEqualTo(0)
                .isLessThan(10);
    }
}
