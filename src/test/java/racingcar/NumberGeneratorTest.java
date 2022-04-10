package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

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
}
