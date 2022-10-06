package test.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {

    @Test
    @DisplayName("전진 조건인 RandomNumber는 0에서 10 사이 숫자")
    void randomUtilTest1() {
        int randomNum = new RandomUtil().generateRandomNum();
        assertThat(randomNum).isGreaterThanOrEqualTo(0);
        assertThat(randomNum).isLessThan(10);
    }
}
