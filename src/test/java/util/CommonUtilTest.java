package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommonUtilTest {

    @Test
    public void 랜덤_숫자_10이하_체크() {
        assertThat(CommonUtil.getRandomNumber())
                .isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(0);
    }
}