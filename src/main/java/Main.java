import step2.InputView;
import step3.domain.RacingGame;

public class Main {

    public static void main(String[] args) {
        racingGameWinStart();
    }

    public static void racingGameStart() {
        InputView inputView = new InputView();
        int carCount = inputView.createCarCount();
        int time = inputView.moveCarCount();

        step2.RacingGame racingGame = new step2.RacingGame(time);
        racingGame.carPositionsInitiate(carCount);
        racingGame.execute();
    }

    public static void racingGameWinStart() {
        step3.view.InputView inputView = new step3.view.InputView();
        String carName = inputView.createCar();
        int time = inputView.moveCount();

        RacingGame racingGame = new RacingGame(time, carName);
        racingGame.execute();
        racingGame.winner();
    }
}
