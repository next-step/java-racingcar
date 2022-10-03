package racingcar;

import racingcar.backend.controller.RacingCarGameController;
import racingcar.frontend.InputView;
import racingcar.frontend.ResultView;

public class GameApp {
    public static void main(String[] args) throws Exception {

        String names = InputView.askNames();
        int times = InputView.askTimes();

        RacingCarGameController racingCarGame = new RacingCarGameController(names, times);
        ResultView.printGameHistory(racingCarGame.start());
    }
}
