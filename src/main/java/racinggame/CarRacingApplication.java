package racinggame;

import java.util.List;

public class CarRacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carsName = inputView.carsName();

        int tryCount = inputView.tryCount();

        RacingGame racingGame = new RacingGame();
        racingGame.readyCar(carsName);

        ResultView resultView = new ResultView();

        resultView.gameResultStart();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playGame();
            resultView.gameResultView(racingGame.getCars());
        }

        List<Car> winnerCar = racingGame.racingWinner(racingGame.getCars());
        resultView.gameWinnerView(winnerCar);
    }

}
