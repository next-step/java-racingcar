package racingCar.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {4,10})
    void random(int range) {
        int number = RandomUtils.random(range);
        assertTrue(number < range);
    }
}
