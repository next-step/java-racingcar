package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {

    @Test
    @DisplayName("Random값이 0-9사이 인지")
    void addTest() {
        RandomNumber randomNumber = new RandomNumber();
        assertTrue(0<= randomNumber.getRandomNumber()
                    &&randomNumber.getRandomNumber() < 10);
    }
}
