package step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {

    @DisplayName("0~9 사이의 숫자가 생성된다")
    @Test
    public void getRandomIntBetweenZeroToNine() {
        // when
        int randomNum = RandomUtil.getRandomIntBetweenZeroToNine();

        // then
        for (int i = 0; i < 100000; i++) {
            assertThat(randomNum).isBetween(0, 9);
        }
    }
}
