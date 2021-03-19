package step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomUtilTest {

    @DisplayName("임의로 생성한 숫자는 0부터 9사이의 숫자를 반환한다.")
    @Test
    public void makeRandomNumber_ShouldReturnBetweenZeroToNine() {
        assertThat(RandomUtil.makeRandomNumber()).isBetween(0, 9);
    }
}
