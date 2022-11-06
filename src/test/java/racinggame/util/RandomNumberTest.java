package racinggame.util;

import org.junit.jupiter.api.Test;
import racinggame.util.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    void test_random_number_size() {
        assertThat(RandomNumber.generate(0, 10)).isBetween(0, 9);
    }
}
