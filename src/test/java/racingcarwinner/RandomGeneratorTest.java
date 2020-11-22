package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class RandomGeneratorTest {

    @Test
    @DisplayName("Random 클래스에서 0부터 9까지의 수가 나오는가?")
    public void RandomValueTest(){

        int randomNumber = RandomGenerator.getRandomNumber();

        for (int i = 0; i < 1000; i++) {
            assertTrue(0 < randomNumber || randomNumber < 9);
        }
    }
}
