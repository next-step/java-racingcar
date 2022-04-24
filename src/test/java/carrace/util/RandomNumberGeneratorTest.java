package carrace.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0에서 9사이 int값 반환")
    void isBetweenZeroAndNine() {
        assertThat(new RandomNumberGenerator().getRandomBetweenZeroAndNine()).isBetween(0, 9);
    }

}