package study.racingcar.strategy;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void policy_test() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int generatedNum = randomNumberGenerator.generate();

        assertThat(generatedNum).isBetween(0, 9);
    }
}