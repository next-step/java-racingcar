package racingCar;

import racingCar.domain.Cars;
import racingCar.domain.NumberOfGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingGame {
    public void startGame() {
        Cars cars = new Cars(InputView.nameList());
        NumberOfGame numberOfGame = new NumberOfGame(InputView.numberOfGame());

        System.out.println("\n실행 결과");
        while (!numberOfGame.isEndGame()) {
            ResultView.resultOfCars(cars);
            numberOfGame.decreaseNumberOfGame();
        }
        ResultView.resultOfWinners(cars);
    }
}
