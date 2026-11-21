package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("0 ~ 9 의 값을 생성한다")
    void generateRandomNumberInRange() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        assertThat(numberGenerator.generate()).isBetween(0, 9);
    }
}
