package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValueGeneratorTest {
    @Test
    void 랜덤_0에서_9사이_값() {
        assertThat(ValueGenerator.generateRandomValue()).isBetween(0, 9);
    }
}

