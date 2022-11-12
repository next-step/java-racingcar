import domain.Cars;
import domain.RacingResult;
import java.util.List;
import view.InputView;
import view.ResultView;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        Cars racingCars = new Cars(InputView.inputCarName());
        List<RacingResult> results = racingCars.race(InputView.inputTryCount());

        ResultView.printResult(results);
        ResultView.printWinners(racingCars);
    }
}
