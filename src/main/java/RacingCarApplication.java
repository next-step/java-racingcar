import racingcar.domain.Racing;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingCarApplication {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();
    static Racing racing = new Racing();

    public static void main(String[] args) {
        racing.initializeCars(inputView.askToInsertNumberOfCars());
        resultView.print(racing.race(inputView.askToInsertNumberOfTries()));
    }
}
