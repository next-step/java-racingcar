package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {
    @Test
    void RandomNumberGenerator은_랜덤한_값을_생성한다() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();

        assertThat(numberGenerator.generate())
                .isBetween(0, RandomNumberGenerator.RANDOM_VALUE_BOUNDARY);
    }
}