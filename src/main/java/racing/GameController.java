package racing;

import java.util.List;

public class GameController {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();


    public void startGame() {

        String carNames = inputView.getCarNames();
        int totalRound = inputView.getTotalRound();

        RacingGame racingGame = new RacingGame(carNames, totalRound);
        List<Car> cars = racingGame.doGame();
        List<String> winners = racingGame.getWinner();

        resultView.printGame(cars, totalRound, winners);
    }


}
