import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤값은 0에서 9사이여야한다.")
    void 랜덤값_조건_검사() {
        final int random = RandomGenerator.create();
        assertTrue(-1 < random && random < 10);
    }
}