package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    @Test
    @DisplayName("0~9사이의 값을 구하는지에 대한 테스트 ")
    void randomValueTest() {
        assertThat(RandomNumberGenerator.generateRandomNumber()).isBetween(0, 9);
    }
}