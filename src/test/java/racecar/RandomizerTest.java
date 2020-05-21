package racecar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomizerTest {

    @Test
    @DisplayName("0-9 사이의 정수를 리턴 하는지 확인")
    void generateNumber() {
        Randomizer randomizer = new Randomizer();
        int result = randomizer.generateNumber();
        assertThat(result).isBetween(0, 9);
    }
}