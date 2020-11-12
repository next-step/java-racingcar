package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤 값이 0과 같거나 크고 10보다 작은가?")
    public void EnableRandomNumber(){
        assertTrue(RandomGenerator.getRandomNumber() >= 0);
        assertTrue(RandomGenerator.getRandomNumber() < 10);
    }
}
