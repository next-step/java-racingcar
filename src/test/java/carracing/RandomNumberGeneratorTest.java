package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static carracing.domain.RandomNumberGenerator.getRandomNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("랜덤값이 0~9 사이의 정수인지 테스트")
    void randomNumberGeneration() {
        assertThat(getRandomNumber()).isBetween(0, 9);
    }
}
