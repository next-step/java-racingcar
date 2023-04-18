package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.NumberUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {
    @DisplayName("3단계 - 자동차 경주 - 생성한 random 값이 0 ~ 9 사이의 숫자인지 확인")
    @Test
    void generate_random_number_between_0_to_9() {
        assertThat(NumberUtil.generateRandomNumberFromZeroToInputNumber(9)).isBetween(0, 9);
    }
}
