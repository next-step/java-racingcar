package controller;

import domain.Racing;
import java.util.List;
import view.InputView;
import view.ResultView;

public class GameController {
    public void play() {
        List<String> carNames = InputView.getCarName();
        int tryCount = InputView.getTryCount();
        InputView.closeScanner();

        Racing racing = new Racing(carNames);

        ResultView.printExecuteResult();

        for (int i = 0; i < tryCount; i++) {
            racing.start();
            ResultView.printRaceRound(racing);
        }

        ResultView.printWinner(racing);

    }
}
