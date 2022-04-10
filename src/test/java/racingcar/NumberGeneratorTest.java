package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @RepeatedTest(30)
    @DisplayName("0 - 9 난수 생성")
    void generateRandomNumberZeroToNine() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();
        // when
        int generatedNumber = numberGenerator.generateRandomNumber();
        // then
        assertThat(generatedNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("input의 길이 만큼 난수 리스트 생성")
    void generateRandomNumberList() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();
        // when
        int roundCount = 5;
        List<Integer> randomNumbers = numberGenerator.generateRandomNumbers(5);
        // then
        assertThat(randomNumbers).hasSize(roundCount);
    }
}
