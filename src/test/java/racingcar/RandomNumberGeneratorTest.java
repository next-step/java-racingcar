package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("랜덤넘버는 0이상 9이하이다.")
    @Test
    void randomNumberIsAnIntegerBetween0And9() {
        int testNum = 50000;
        for (int i = 0; i < testNum; i++) {
            assertThat(new RandomNumGenerator().getRandomNumber()).isBetween(0,9);
        }
    }
}
