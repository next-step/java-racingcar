import step3.domain.Racing;
import step3.view.InputView;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carNumber = inputView.carNumberInput();
        String attemptNumber = inputView.attemptNumberInput();

        Racing racing = new Racing(carNumber, attemptNumber);

        racing.racingStart();

    }
}
