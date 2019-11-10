package step3.racingcarWinner;

import step3.racingcarWinner.domain.Car;
import step3.racingcarWinner.domain.RacingGame;
import step3.racingcarWinner.view.InputView;
import step3.racingcarWinner.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int racingLap = inputView.racingLap();
        String carNames = inputView.carNames();

        RacingGame racingGame = new RacingGame(carNames, racingLap);

        ResultView resultView = new ResultView(racingGame);
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < racingLap; i++) {
            carList = resultView.printCurrentCarListPosition(racingGame.run());
        }
        resultView.printFinalWinner(racingGame.prize(carList));
    }

}
