import controller.RacingGame;
import view.InputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        RacingGame racingGame = new RacingGame(carNames, tryNumber);
    }
}
