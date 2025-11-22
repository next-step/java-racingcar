package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundCountTest {
    @Test
    void create() {
        Assertions.assertThat(new RoundCount(1).value()).isEqualTo(1);
    }

    @Test
    void decrease() {
        Assertions.assertThat(new RoundCount(1).decrease()).isEqualTo(new RoundCount());
    }
}
