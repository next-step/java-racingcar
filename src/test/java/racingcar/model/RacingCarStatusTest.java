package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarStatusTest {
    @Test
    @DisplayName("RacingCarStatus를 생성 후 add를 호출했을 때 value가 증가하는지 확인한다.")
    void value_add() {
        RacingCarPosition rcp = new RacingCarPosition();
        rcp = rcp.add();
        assertThat(rcp.equals(new RacingCarPosition(1)));
    }
}
