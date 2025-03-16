package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    // 1000번 반복하여 테스트
    @RepeatedTest(value = 1000, name = "0~9사이 값만 나오는지 확인 {currentRepetition} of {totalRepetitions}")
    void generate() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(Cars.BOUND);
        int randomValue = randomNumberGenerator.generate();
        Assertions.assertThat(randomValue).isBetween(0, 9);
    }
}
