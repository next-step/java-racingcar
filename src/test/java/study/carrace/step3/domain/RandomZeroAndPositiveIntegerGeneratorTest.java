package study.carrace.step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RandomZeroAndPositiveIntegerGeneratorTest {
    @ParameterizedTest(name = "[{index}/3] 0과 {arguments} 사이의 랜덤한 정수 생성 테스트")
    @ValueSource(ints = {5, 10, 15})
    void generate(int maxNumber) {
        // given
        int minValue = 0;
        int iterationCount = 10_000;

        int highestRandomNumber = Integer.MIN_VALUE;
        int lowestRandomNumber = Integer.MAX_VALUE;

        RandomZeroAndPositiveIntegerGenerator randomIntGenerator =
                new RandomZeroAndPositiveIntegerGenerator(maxNumber);

        // when
        for (int i = 0; i < iterationCount; i++) {
            int generated = randomIntGenerator.generate();

            if (generated > highestRandomNumber) {
                highestRandomNumber = generated;
            }
            if (generated < lowestRandomNumber) {
                lowestRandomNumber = generated;
            }
        }

        // then
        assertThat(highestRandomNumber).isEqualTo(maxNumber);
        assertThat(lowestRandomNumber).isEqualTo(minValue);
    }
}