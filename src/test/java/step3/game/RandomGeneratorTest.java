package step3.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("랜덤 값은 0-9사이의 값이 만들어진다.")
    void makeRandom() {
        int randomValue = RandomGenerator.getRandomValue();
        assertTrue(
                randomValue >= 0 && randomValue <= 9,
                "랜덤 값은 0-9 사이의 값이어야 합니다."
        );
    }
}
