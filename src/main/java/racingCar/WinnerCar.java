package racingCar;

import java.util.List;
import java.util.Map;

public class WinnerCar {
    public static void main(String[] args) {
        Map<String, Object> inputMap = InputView.inputNamedCar();
        String carNames = inputMap.get("carNames").toString();
        int tyrNum = (int) inputMap.get("tryNum");

        Cars cars = new Cars(carNames);
        RacingCar.movingNamedCarResult(cars, tyrNum);
        WinnerCar.returnWinner(cars);
    }

    public static List<String> returnWinner(Cars cars){
        List<String> winners = cars.returnWinnerCars();

        ResultView.printWinner(winners);

        return winners;
    }
}
