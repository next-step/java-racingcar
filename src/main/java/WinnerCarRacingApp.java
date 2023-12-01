import racingCar.domain.Cars;
import racingCar.domain.RacingResult;
import racingCar.domain.RandomNumber;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.List;
import java.util.Map;

public class WinnerCarRacingApp {
    public static void main(String[] args) {
        Map<String, Object> inputMap = InputView.winnerInput();
        String carNames = inputMap.get("carNames").toString();
        int tryNum = (int) inputMap.get("tryNum");

        Cars cars = new Cars(carNames);

        List<String> status = cars.repeatMove(tryNum, new RandomNumber());
        RacingResult racingResult = new RacingResult(cars);

        ResultView.printCarStatus(status);

        ResultView.printWinner(racingResult.returnWinnerCar());
    }
}
