package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    void createRandomNumberTest() {
        assertThat(RandomNumber.createRandomNumber()).isBetween(0, 9);
    }
}
