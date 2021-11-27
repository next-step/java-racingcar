package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarPositionTest {
    @DisplayName("maxPosition 함수는 매개변수와 self 중 position(int) 값이 더 큰 CarPosition을 반환한다.")
    @Test
    void maxPosition() {
        CarPosition basePosition = new CarPosition(10);
        CarPosition smallPosition = new CarPosition(9);
        CarPosition bigPosition = new CarPosition(11);
        assertThat(basePosition.maxPosition(smallPosition)).isEqualTo(basePosition);
        assertThat(basePosition.maxPosition(bigPosition)).isEqualTo(bigPosition);
    }
}
