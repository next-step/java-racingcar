import step3.domain.Racing;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingGame {

    private static ResultView resultView;

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carNumber = inputView.carNumberInput();
        int attemptNumber = inputView.attemptNumberInput();

        Racing racing = new Racing(carNumber,attemptNumber);

        resultView = new ResultView(racing);

        resultView.resultOutput();





    }
}
