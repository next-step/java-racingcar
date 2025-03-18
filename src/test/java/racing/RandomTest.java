package racing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

public class RandomTest {

    @Test
    void testFixedRandomValue() {
        // ✅ 항상 3을 리턴하는 Random 구현
        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };

        RandomUtils randomUtils = new RandomUtils(fixedRandom);
        assertEquals(3, randomUtils.getRandomNumber(10)); // 항상 3이 나옴
    }

    @Test
    void testAnotherFixedRandomValue() {
        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };

        RandomUtils randomUtils = new RandomUtils(fixedRandom);
        assertEquals(5, randomUtils.getRandomNumber(10)); // 항상 5가 나옴
    }

    @Test
    void random_숫자의_범위를_지정한다() {
        Random random = new Random();
        RandomUtils randomUtils = new RandomUtils(random);
        for (int i = 0; i < 100; i++) {
            int number = randomUtils.getRandomNumber(5);
            if (number < 0 || number >= 5) {
                throw new IllegalStateException("랜덤 값이 범위를 벗어났습니다.");
            }
        }
    }

}
