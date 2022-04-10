package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Number generator test.
 */
class NumberGeneratorTest {

    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @RepeatedTest(30)
    @DisplayName("0 - 9 난수 생성")
    void generateRandomNumberZeroToNine() {
        assertThat(numberGenerator.generateRandomNumber()).isBetween(0, 9);
    }

    @Test
    @DisplayName("input의 길이 만큼 난수 리스트 생성")
    void generateRandomNumberList() {
        int roundCount = 5;
        assertThat(numberGenerator.generateRandomNumbers(roundCount)).hasSize(roundCount);
    }
}
