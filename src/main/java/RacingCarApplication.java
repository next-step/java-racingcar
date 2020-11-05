import racingcar.domain.Racing;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingCarApplication {
    static Racing racing;

    public static void main(String[] args) throws Exception {
        int numberOfCars = InputView.askToInsertNumberOfCars();
        int numberOfTries = InputView.askToInsertNumberOfTries();

        racing = new Racing(numberOfCars);
        String result = racing.race(numberOfTries);

        ResultView.print(result);
    }
}
