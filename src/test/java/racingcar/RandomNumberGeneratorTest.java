package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @RepeatedTest(10)
    @DisplayName("0이상 9이하의 랜덤 숫자를 반환한다.")
    void randomNumberGenerateTest() {
        assertThat(randomNumberGenerator.generateRandomNumber()).isBetween(0, 10);
    }

}