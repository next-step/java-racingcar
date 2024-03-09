package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {

    @RepeatedTest(value = 100)
    @DisplayName("0 ~ 9 사이의 정수 값을 반환한다")
    void randomNumber() {
        assertThat(RandomUtil.randomNumber()).isBetween(0, 9);
    }
}
