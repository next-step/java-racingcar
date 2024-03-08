package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {

    @Test
    @DisplayName("0 ~ 9 사이의 정수 값을 반환한다")
    void randomNumber() {
        for (int i = 1; i <= 1000; i++) {
            assertThat(RandomUtil.randomNumber()).isBetween(0, 9);
        }
    }
}
