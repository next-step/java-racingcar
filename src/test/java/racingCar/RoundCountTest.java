package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundCountTest {
    @Test
    void create() {
        Assertions.assertThat(new RoundCount(1).value()).isEqualTo(1);
    }
}
