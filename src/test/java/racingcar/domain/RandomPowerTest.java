package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class RandomPowerTest {

    @DisplayName("싱글턴 테스트")
    @Test
    public void singletonTest() {
        RandomPower randomPower1 = RandomPower.getInstance();
        RandomPower randomPower2 = RandomPower.getInstance();

        assertNotNull(randomPower1);
        assertNotNull(randomPower2);
        assertSame(randomPower1, randomPower2);
    }

    @DisplayName("랜덤값 범위 검증")
    @RepeatedTest(100)
    public void makeRandomIntValue() {
        assertThat(RandomPower.getInstance().nextInt())
                .isGreaterThanOrEqualTo(0)
                .isLessThan(10);
    }
}
