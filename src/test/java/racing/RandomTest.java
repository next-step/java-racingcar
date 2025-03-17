package racing;

import org.junit.jupiter.api.Test;
import utils.RandomUtils;

public class RandomTest {

    @Test
    void randomAlwaysUnder5() {
        for (int i = 0; i < 100; i++) {
            int random = RandomUtils.getRandomNumber(5);
            if (random < 0 || random >= 5) {
                throw new IllegalStateException("랜덤 값이 범위를 벗어났습니다.");
            }
        }
    }

}
