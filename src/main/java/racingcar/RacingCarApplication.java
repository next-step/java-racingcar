package racingcar;

import racingcar.domain.RacingGameController;
import racingcar.domain.Records;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarOutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingGameController controller = RacingGameController.getInstance();
        RacingCarInputView inputView = RacingCarInputView.getInstance();
        RacingCarOutputView outputView = RacingCarOutputView.getInstance();

        inputView.carInputPrompt();
        String[] names = inputView.inputName();

        inputView.lapInputPrompt();
        int laps = inputView.input();

        Records result = controller.execute(names, laps);

        outputView.outputPrompt(result);
    }
}
