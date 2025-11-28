package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.*;

public class RandomNumberGeneratorTest {
    @DisplayName("0 ~ 9까지의 난수를 생성한다.")
    @RepeatedTest(10)
    public void ramdomNumberFrom0To9() {
        int result = RandomNumberGenerator.random();

        assertThat(result).isBetween(0, 9);
    }
}
