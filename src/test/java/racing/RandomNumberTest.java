package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();

    }

    @Test
    @DisplayName("Random값이 0-9사이 인지")
    void getRandomNumberTest() {
        assertTrue(0 <= randomNumber.getRandomNumber()
                && randomNumber.getRandomNumber() < 10);
    }
}
