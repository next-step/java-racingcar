package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import racingcarrefectoring.model.RandomGenerator;

import static org.junit.Assert.assertTrue;

public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤값을 제대로 반환하는가")
    public void getRandomNumber(){
        int randomNumber = RandomGenerator.getRandomNumber();
        for (int i = 0; i < 100; i++) {
            assertTrue(0 <= randomNumber  || randomNumber < 10);
        }
    }
}
