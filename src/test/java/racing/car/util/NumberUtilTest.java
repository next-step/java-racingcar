package racing.car.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberUtilTest {

    @Test
    void 영부터구_랜덤숫자() {
        boolean isRandom = true;
        for (int i = 0; i < 100; i++) {
            int result = NumberUtil.randomInt(0, 9);
            if (result < 0 || result > 9) {
                isRandom = false;
            }
            assertThat(isRandom).isTrue();
        }
    }

}
