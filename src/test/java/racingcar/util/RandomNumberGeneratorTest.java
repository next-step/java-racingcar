package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.movement.RandomNumberGenerator;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0이상 9이하의 난수를 정상적으로 생성한다.")
    void generate_RandomNumber_BetweenZeroAndNine() {
        assertThat(new RandomNumberGenerator().generate()).isBetween(0, 9);
    }
}
