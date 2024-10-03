package step5;

import step5.domain.PreparedCarGame;
import step5.domain.game.GameStrategy;
import step5.domain.game.RacingCarGame;
import step5.uiview.InputView;
import step5.uiview.ResultView;

public class CarGameMain {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        PreparedCarGame carGame = new PreparedCarGame();

        String carName = inputView.inputCarName();
        int attemptNum = inputView.inputAttemptNum();

        carGame.ready(racingCarGame(carName, attemptNum));

        carGame.startRace();

        resultView.resultView(carGame);

    }

    private static GameStrategy racingCarGame(String carName, int attemptNum) {
        RacingCarGame carGame = new RacingCarGame();
        carGame.readyRace(carName, attemptNum);
        return carGame;
    }

}
