import game.GameStrategy;
import game.PreparedCarGame;
import game.RacingCarGame;
import uiview.InputView;

public class CarGameMain {

    private final static InputView inputView = new InputView();

    public static void main(String[] args) {

        PreparedCarGame carGame = new PreparedCarGame();

        int carNum = inputView.inputCarNum();
        int attemptNum = inputView.inputAttemptNum();

        carGame.ready(racingCarGame(carNum, attemptNum));
        carGame.startRace();

    }

    public static GameStrategy racingCarGame(int carNum, int attemptNum) {
        RacingCarGame carGame = new RacingCarGame();
        carGame.readyRace(carNum, attemptNum);
        return carGame;
    }

}
