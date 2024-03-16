package racingcar.domain.movement;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.movement.RandomNumberGenerator.RANDOM_NUMBER_MAXIMUM;
import static racingcar.domain.movement.RandomNumberGenerator.RANDOM_NUMBER_MINIMUM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0이상 9이하의 난수를 생성한다.")
    void generate_RandomNumber_BetweenZeroAndNine() {
        assertThat(new RandomNumberGenerator().generate())
                .isBetween(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM);
    }
}
