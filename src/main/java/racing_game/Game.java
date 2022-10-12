package racing_game;

import java.util.List;
import racing_game.controller.Simulator;
import racing_game.core.Positive;
import racing_game.domain.SnapShot;
import racing_game.domain.CarName;
import racing_game.view.InputView;
import racing_game.view.ResultView;

public class Game {

    // servlet
    public void run() {
        try {
            // 1. request
            InputView inputView = new InputView();
            List<CarName> carNames = inputView.getCarNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
            Positive tryCount = inputView.getPositive("시도할 회수는 몇 회 인가요?");

            // 2. controller
            SnapShot result = new Simulator().simulate(tryCount, carNames);

            // 3. response - view resolve
            ResultView resultView = new ResultView();
            resultView.showResult(result);
        } catch (Exception e) {
            System.out.println("the game error occurred");
            e.printStackTrace();
        }
    }
}
