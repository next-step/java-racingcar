package racing.util;

import org.junit.jupiter.api.Test;
import racing.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @Test
    void 랜덤값은_0부터_9까지의_숫자() {
        assertThat(RandomGenerator.generate()).isBetween(0, 9);
    }
}
