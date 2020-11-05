import racingcar.domain.Racing;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingCarApplication {
    static Racing racing = new Racing();

    public static void main(String[] args) {
        int numberOfCars = InputView.askToInsertNumberOfCars();
        int numberOfTries = InputView.askToInsertNumberOfTries();

        racing.initializeCars(numberOfCars);
        String result = racing.race(numberOfTries);

        ResultView.print(result);
    }
}
