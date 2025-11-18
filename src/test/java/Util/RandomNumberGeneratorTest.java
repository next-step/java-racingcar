package Util;

import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.*;

public class RandomNumberGeneratorTest {
    @RepeatedTest(10)
    public void ramdomNumberFrom0To10() {
        int result = RandomNumberGenerator.random();

        assertThat(result).isBetween(0, 9);
    }
}
