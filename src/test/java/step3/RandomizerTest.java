package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomizerTest {

    @Test
    void generateNumber() {
        Randomizer randomizer = new Randomizer();
        int result = randomizer.generateNumber();
        assertThat(result).isBetween(0, 9);
    }
}