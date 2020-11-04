import racingcar.domain.Racing;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingCarApplication {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();
    static Racing racing = new Racing();

    public static void main(String[] args) {

        int numberOfCars = inputView.askToInsertNumberOfCars();
        int numberOfTries = inputView.askToInsertNumberOfTries();

        racing.initializeCars(numberOfCars);
        String result = racing.race(numberOfTries);

        resultView.print(result);
    }
}
