package util;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomUtilTest {

    @RepeatedTest(1000)
    void getRandomValueTest() {
        int max = 10;
        int randomNumber = RandomUtil.getRandomValue(max);

        assertTrue(randomNumber < max);
    }
}