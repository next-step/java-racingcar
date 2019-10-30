package step3;

import step3.domain.Car;
import step3.domain.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class RacingGameController {

    public void RacingGameStart() {
        RacingGame racingGame = initiate();
        moveResultView(racingGame);
        winnerView(racingGame);
    }

    public RacingGame initiate() {
        InputView inputView = new InputView();
        String carObject = inputView.createCar();
        int moveCount = inputView.moveCount();
        return new RacingGame(moveCount, carObject);

    }

    public void moveResultView(RacingGame racingGame) {
        for (int i = 0; i < racingGame.getTime(); i++) {
            List<Car> cars = racingGame.move();
            ResultView.printResultView(cars);
        }
    }

    public void winnerView(RacingGame racingGame) {
        List<String> winners = racingGame.winner();
        ResultView.printWinner(winners);
    }
}
