import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    public static void main(String[] args) {

//        int carCount = InputView.getAnswerToInteger(Messages.ASK_CAR_COUNT);

        String[] carNames = InputView.getCarNames();

        List<Car> cars = CarUtils.generateCarsWithName(carNames);

        int tryTimes = InputView.getAnswerToInteger(Messages.ASK_TRY_TIMES);

        ResultView.println(Messages.RACE_RESULT);

        for (int j = 0; j < tryTimes; j++) {
            CarUtils.moveCars(cars);
        }

        List<Car> winnerCars = CarUtils.getWinnerCars(cars);

        ResultView.printWinner(winnerCars);
    }
}