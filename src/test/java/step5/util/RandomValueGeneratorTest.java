package step5.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomValueGeneratorTest {
    @RepeatedTest(value = 10)
    @DisplayName("0에서 9이하의 랜덤 값을 생성한다.")
    void generateRandomValueFromZeroToNine() {
        //given
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

        //when
        int randomValue = randomValueGenerator.getMoveValue();

        //then
        assertThat(randomValue).isBetween(0, 9);
    }
}
