package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class RandomUtilTest {

    @Test
    @DisplayName("0에서 9사이에서 구한 random 값을 반환한다")
    void generate_random_number() {
        int random = RandomUtil.generateRandomNumber();
        assertTrue(random >= 0 && random < 10);
    }
}
