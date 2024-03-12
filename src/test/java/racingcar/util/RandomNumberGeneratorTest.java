package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0 ~ 9 사이의 random 값만 생성한다.")
    void generateRandomNumberTest() {
        int resultNumber;
        for (int i = 0; i < 1000; i++) {
            resultNumber = RandomNumberGenerator.generateRandomNumber();

            assertTrue(resultNumber >= 0);
        }
    }
}