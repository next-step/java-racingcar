import step2.InputView;
import step2.RacingGame;

public class Main {

    public static void main(String[] args) {
        racingGameStart();
    }

    public static void racingGameStart() {
        InputView inputView = new InputView();
        int carCount = inputView.createCarCount();
        int time = inputView.moveCarCount();

        RacingGame racingGame = new RacingGame(time);
        racingGame.carPositionsInitiate(carCount);
        racingGame.execute();
    }
}
