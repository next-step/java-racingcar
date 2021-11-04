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
        Input input = new InputView();
        Output output = new ResultView();
        execute(input, output);
    }

    private static void execute(Input input, Output output) {
        InputValue inputValue = input.getInputValue();
        RacingCarService racingCarService = RacingCarService.init(inputValue.getCarCount());

        for (int i = GAME_START_COUNT; i <= inputValue.getRetryCount(); i++) {
            Cars result = racingCarService.start();
            output.output(i, result);
        }
    }
}
