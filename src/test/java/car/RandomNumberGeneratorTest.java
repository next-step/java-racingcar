package car;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setRandomNumberGenerator() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void 숫자_범위_확인_테스트() {
        int randomNumber = randomNumberGenerator.makeRandomNumber();
        assertTrue(randomNumber >= 0 && randomNumber < 10);
    }
}
