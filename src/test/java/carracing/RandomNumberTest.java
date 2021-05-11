package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {
    RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    void createRandomNumberTest() {
        Assertions.assertThat(randomNumber.createRandomNumber()).isLessThanOrEqualTo(9);
    }
}
