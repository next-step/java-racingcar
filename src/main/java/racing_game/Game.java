package racing_game;

import racing_game.controller.Simulator;
import racing_game.core.Positive;
import racing_game.core.SnapShot;
import racing_game.view.InputView;
import racing_game.view.ResultView;

public class Game {

    // servlet
    public void run() {
        try {
            // 1. request
            InputView inputView = new InputView();
            Positive carCount = inputView.getInput("자동차 대수는 몇 대 인가요?");
            Positive tryCount = inputView.getInput("시도할 회수는 몇 회 인가요?");

            // 2. controller
            SnapShot result = new Simulator().simulate(tryCount, carCount);

            // 3. response - view resolve
            ResultView resultView = new ResultView();
            resultView.showResult(result);
        } catch (Exception e) {
            System.out.println("the game error occurred");
            e.printStackTrace();
        }
    }
}
