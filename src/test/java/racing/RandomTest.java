package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    private RandomGenerator randomGenerator = new RandomGenerator();
    private final int BIG_ENOUGH = 1000;

    @DisplayName("무작위 값은 0에서 9 사이에서 무조건 나온다.")
    @Test
    void randomTest() {
        for (int iterator = 0; iterator < BIG_ENOUGH; iterator++) {
            assertThat(randomGenerator.create()).isBetween(0, 9);
        }
    }
}
