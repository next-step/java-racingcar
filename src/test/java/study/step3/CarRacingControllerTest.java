package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.CarRacing;
import study.step3.view.InputView;
import study.step3.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingControllerTest {

    private CarRacingController carRacingController;
    private CarRacing mockCarRacing;
    private ResultView mockResultView;
    private InputView mockInputView;


    @Test
    @DisplayName("컨트롤러는 내부 객체와 상호작용을 한다.")
    void interact() {
        carRacingController.invoke();

        assertThat(mockInputView).extracting("interacted").containsExactly(true);
        assertThat(mockCarRacing).extracting("interacted").containsExactly(true);
        assertThat(mockResultView).extracting("interacted").containsExactly(true);
    }

}
