package step3;

import step3.game.GameStrategy;
import step3.game.PreparedCarGame;
import step3.game.RacingCarGame;
import step3.uiview.InputView;
import step3.uiview.ResultView;

public class CarGameMain {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        PreparedCarGame carGame = new PreparedCarGame();

        int carNum = inputView.inputCarNum();
        int attemptNum = inputView.inputAttemptNum();

        carGame.ready(racingCarGame(carNum, attemptNum));
        carGame.startRace();

        resultView.resultView(carGame.getRaceSituation());

    }

    public static GameStrategy racingCarGame(int carNum, int attemptNum) {
        RacingCarGame carGame = new RacingCarGame();
        carGame.readyRace(carNum, attemptNum);
        return carGame;
    }

}
