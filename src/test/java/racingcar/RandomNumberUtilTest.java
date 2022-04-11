package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.util.RandomNumberUtil;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberUtilTest {

    @RepeatedTest(10)
    @DisplayName("0이상 9이하의 랜덤 숫자를 반환한다.")
    void randomNumberGenerateTest() {
        assertThat(RandomNumberUtil.generateRandomNumber()).isBetween(0, 10);
    }

}