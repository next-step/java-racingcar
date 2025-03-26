package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarControllerTest {

    @Test
    @DisplayName("n대의 자동차를 생성할 수 있다.")
    void generateCarForParticipantTest() {
        RacingCarController controller = new RacingCarController(3, 5, new OutputView());
        assertThat(controller.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("지정된 횟수만큼 자동차 경주를 진행할 수 있다.")
    void controlOperationCountTest() {
        RacingCarController controller = new RacingCarController(3, 5, new OutputView());
        assertThat(controller.getOperationCount()).isEqualTo(5);
    }
}