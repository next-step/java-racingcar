package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("랜덤으로 생성한 수의 범위 테스트")
    @Test
    void randomNumberRangeTest() {
        for (int i = 0; i < 1000; i++) {
            assertThat(RandomNumberGenerator.getRandomNumber()).isBetween(0, 9);
        }
    }
}
