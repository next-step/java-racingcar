package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {
    @Test
    void random() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Assertions.assertThat(isActual(random)).isTrue();
        }
    }

    private boolean isActual(Random random) {
        return random.nextInt(5) <= 4 && random.nextInt(5) >= 0;
    }
}
