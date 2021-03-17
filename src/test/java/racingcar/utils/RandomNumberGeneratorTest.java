package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0~9 사이의 난수 생성 테스트")
    public void generate() throws Exception {
        for (int i = 0; i < 1000; i++) {
            int randomNumber = RandomNumberGenerator.generate();
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(9);
        }
    }
}