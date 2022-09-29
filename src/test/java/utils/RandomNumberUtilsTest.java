package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberUtilsTest {

    @Test
    void 랜덤값() {
        Assertions.assertThat(RandomNumberUtils.getRandomNumber(10)).isBetween(0, 9);
    }

}
