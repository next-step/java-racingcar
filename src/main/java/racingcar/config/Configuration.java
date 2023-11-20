package racingcar.config;

import java.util.Scanner;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Configuration {

    public InputView inputView() {
        return new InputView(scanner());
    }

    private Scanner scanner() {
        return new Scanner(System.in);
    }

    public RacingGameController racingGameController() {
        return new RacingGameController(outputView());
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
