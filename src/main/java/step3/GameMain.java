package step3;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        String carNames = inputView.getCarNames();
        int totalRound = inputView.getTotalRound();

        RacingGame racingGame = new RacingGame(carNames, totalRound);
        List<Car> cars = racingGame.doGame();
        List<String> winners = racingGame.getWinner();

        ResultView resultView = new ResultView();
        resultView.printGame(cars, totalRound, winners);


    }
}
