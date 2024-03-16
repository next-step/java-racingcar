package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import utils.number.RandomNumberGenerator;

class RandomNumberTest {

    @Test
    void 랜덤번호_생성기() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int count = 10000;
        for (int i = 0; i < count; i++) {
            assertThat(randomNumberGenerator.generate()).isBetween(0, 9);
        }
    }
}