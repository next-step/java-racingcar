package racing;

import racing.domain.Cars;
import racing.domain.RacingCarGame;
import racing.view.InputView;
import racing.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView.input();
        Cars cars = RacingCarGame.initialize(InputView.carNames(), InputView.moveCount());
        for (int i = 0; i < cars.moveCount(); i++) {
            RacingCarGame.progress(cars);
            ResultView.printRace(cars, RacingCarGame.isStart());
        }
        ResultView.showWinner(cars);
    }
}
