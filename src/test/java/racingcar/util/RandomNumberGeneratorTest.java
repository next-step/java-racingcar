package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.RandomNumberGenerator.generateRandomNumberBetweenZeroAndNine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0이상 9이하의 난수를 정상적으로 생성한다.")
    void generate_RandomNumber_BetweenZeroAndNine() {
        assertThat(generateRandomNumberBetweenZeroAndNine()).isBetween(0, 9);
    }
}
