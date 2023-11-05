package step3.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomValueGeneratorTest {
    @Test
    @DisplayName("0에서 9이하의 랜덤 값을 생성한다.")
    void generateRandomValueFromZeroToNine() {
        //given
        //when
        int randomValue = RandomValueGenerator.generateRandomValueFromZeroToNine();

        //then
        assertThat(randomValue).isBetween(0, 9);
    }
}
