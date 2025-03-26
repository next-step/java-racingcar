package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarControllerTest {

    @Test
    @DisplayName("n대의 자동차를 생성할 수 있다.")
    void generateCarForParticipantTest() {
        RacingCarController controller = new RacingCarController(3);
        assertThat(controller.getCars()).hasSize(3);
    }
}