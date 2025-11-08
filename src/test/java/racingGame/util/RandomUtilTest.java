package racingGame.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomUtilTest {
    
    @Test
    void randomValueTest() {
        assertNotNull(RandomUtil.generateInt());
    }
    
    @Test
    void randomValueAroundOneToNineTest() {
        int number = RandomUtil.generateInt();
        assertTrue(number < 10);
        assertTrue(number >= 0);
    }

}