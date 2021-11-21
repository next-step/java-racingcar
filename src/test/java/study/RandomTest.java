package study;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    void nextInt() {
        Random random = new Random();

        int bound = 10;

        for (int i = 0; i < 100000; i++) {
            int r = random.nextInt(bound);
            assertThat(r).isGreaterThanOrEqualTo(0);
            assertThat(r).isLessThan(bound);
        }
    }
}
