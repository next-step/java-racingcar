package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static racingcar.RacingRandom.*;

public class RacingRandomTest {
    @Test
    void random() {
        RacingRandom random = getInstance();
        for (int i = 0; i < 100; i++) {
            Assertions.assertThat(isActual(random.getNumber())).isTrue();
        }
    }

    private boolean isActual(int number) {
        return number <= 10 && number >= 0;
    }
}
