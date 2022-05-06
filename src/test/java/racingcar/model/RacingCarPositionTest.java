package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarPositionTest {
    @Test
    @DisplayName("RacingCarStatus를 생성 후 add를 호출했을 때 value가 증가하는지 확인한다.")
    void value_add() {
        RacingCarPosition rcp = new RacingCarPosition();
        rcp = rcp.add();
        assertThat(rcp).isEqualTo(new RacingCarPosition(1));
    }

    @Test
    @DisplayName("위치가 0 이상인지 검증한다.")
    void value_validation() {
        RacingCarPosition rcp = new RacingCarPosition(-1);
        assertThat(rcp.checkPosition()).isFalse();
    }
}
