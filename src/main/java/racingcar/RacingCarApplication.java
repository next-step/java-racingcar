package racingcar;

import racingcar.service.RacingCarService;
import racingcar.service.dto.Cars;
import racingcar.ui.Input;
import racingcar.ui.InputView;
import racingcar.ui.Output;
import racingcar.ui.ResultView;
import racingcar.ui.model.InputValue;

public class RacingCarApplication {
    private static final int GAME_START_COUNT = 1;

    public static void main(String[] args) {
        Input inputView = new InputView();
        Output resultView = new ResultView();
        execute(inputView, resultView);
    }

    private static void execute(Input inputView, Output resultView) {
        InputValue inputValue = inputView.input();
        RacingCarService racingCarService = RacingCarService.init(inputValue.getCarCount());

        for (int i = GAME_START_COUNT; i <= inputValue.getRetryCount(); i++) {
            Cars result = racingCarService.start();
            resultView.output(i, result);
        }
    }
}
