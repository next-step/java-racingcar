package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @RepeatedTest(value = 30)
    @DisplayName("random 값은 0에서 9 사이에서 생성한다.")
    void createRandomBetween() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertThat(numberGenerator.generate()).isBetween(0, 9);
    }

}