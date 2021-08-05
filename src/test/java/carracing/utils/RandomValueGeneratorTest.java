package carracing.utils;

import static carracing.utils.RandomValueGenerator.generateRandom;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomValueGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("주어진 범위의 랜덤 값들 반환할 수 있다.")
    void randomValueGenerateTest() {

        assertThat(generateRandom())
            .isGreaterThan(-1).isLessThan(11);
    }
}