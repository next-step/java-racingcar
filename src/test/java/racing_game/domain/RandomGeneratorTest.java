package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    void getRandomValue() {
        RandomGenerator generator = RandomGenerator.create();
        int value = generator.getRandomValue();
        assertThat(value).isGreaterThanOrEqualTo(0).isLessThan(10);
    }

}