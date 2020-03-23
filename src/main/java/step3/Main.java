package step3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printCarCountInfo();
        int carCount = inputView.readInputInt();

        inputView.printRoundTimeInfo();
        int roundTime = inputView.readInputInt();

        RacingGame racingGame = new RacingGame();
        List<Car> carList = racingGame.play(carCount, roundTime);

        ResultView resultView = new ResultView();
        resultView.printResultInfo();
        resultView.printResult(carList, roundTime);
    }
}
