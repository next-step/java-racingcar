package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarPosition;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarPositionTest {
    @Test
    void maxPosition() {
        CarPosition position = new CarPosition(10);
        assertThat(position.maxPosition(9)).isEqualTo(10);
        assertThat(position.maxPosition(11)).isEqualTo(11);
    }
}
