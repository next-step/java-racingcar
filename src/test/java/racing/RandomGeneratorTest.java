package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    @DisplayName("Random Number가 0이상 9 이하여야한다.")
    void getRandomNumber() {
        assertAll(() -> {
            assertThat(RandomGenerator.getRandomNumber()).isGreaterThan(0);
            assertThat(RandomGenerator.getRandomNumber()).isLessThan(10);
        });
    }
}