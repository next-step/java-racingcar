package racingcar;

import racingcar.web.RacingGameController;
import racingcar.web.RacingGameService;

public class WebMain {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new RacingGameService());
        racingGameController.start(8080);
    }
}
