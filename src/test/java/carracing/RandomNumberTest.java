package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    void createRandomNumberTest() {
        assertThat(randomNumber.createRandomNumber()).isLessThanOrEqualTo(9);
    }
}
