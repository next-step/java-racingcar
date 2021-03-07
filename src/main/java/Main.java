import racingcar.controller.RacingCarGameController;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameRule;
import racingcar.dto.RacingCarGameRequest;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        RacingCarGameController.run();
    }
}
