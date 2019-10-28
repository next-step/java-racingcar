import step2.InputView;
import step2.RacingGame;
import step3.RacingGameWin;

public class Main {

    public static void main(String[] args) {
        racingGameWinStart();
    }

    public static void racingGameStart() {
        InputView inputView = new InputView();
        int carCount = inputView.createCarCount();
        int time = inputView.moveCarCount();

        RacingGame racingGame = new RacingGame(time);
        racingGame.carPositionsInitiate(carCount);
        racingGame.execute();
    }

    public static void racingGameWinStart() {
        step3.InputView inputView = new step3.InputView();
        String carName = inputView.createCar();
        int time = inputView.moveCount();

        RacingGameWin racingGameWin = new RacingGameWin(time, carName);
        racingGameWin.initiateCar();
        racingGameWin.execute();
    }
}
