package racingcar.step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilTest {

    @Test
    @DisplayName("난수 생성하기")
    void 난수생성() {
        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(RandomUtil.generateRandomNumber()).isBetween(0, 9);
        }
    }

}