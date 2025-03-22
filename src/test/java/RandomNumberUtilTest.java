import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberUtilTest {

    @Test
    @DisplayName("0부터 9까지의 랜덤 숫자를 반환한다.")
    void getRandomNumberFromZeroToNine() {
        assertThat(RandomNumberUtil.getRandomNumberFromZeroToNine()).isBetween(0, 9);
    }
}
