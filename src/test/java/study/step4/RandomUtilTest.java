package study.step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {

    @Test
    public void 랜덤넘버생성테스트() {
        assertThat(RandomUtil.makeRandomNumber(7, 8)).isLessThan(9);
        assertThat(RandomUtil.makeRandomNumber(7, 8)).isGreaterThan(6);
    }
}