
import racing.RacingCar;
import racing.view.InputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = InputView.enterInput();
        RacingCar racingCar = new RacingCar(inputView.getNumberOfCar(), inputView.getAttempt());
        racingCar.play();
    }
}
