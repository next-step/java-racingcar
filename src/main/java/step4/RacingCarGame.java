package step4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    public static void main(String[] args) {
        List<Car> cars = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();
        List<RacingResult> racingResult = race(cars, tryCount);
        ResultView.printResult(racingResult);
        ResultView.printWinner(getWinners(cars));
    }

    private RacingCarGame() {}

    public static List<RacingResult> race(List<Car> cars, int tryCount) {
        List<RacingResult> racingResults = new ArrayList<>();
        for (int i = 1; i <= tryCount; i++) {
            tryOneRound(cars);
            racingResults.add(new RacingResult(cars));
        }
        return racingResults;
    }

    public static List<Car> getWinners(List<Car> cars) {
        Integer maxPosition = cars.stream()
            .map(car -> car.getDistance())
            .sorted(Comparator.reverseOrder())
            .findFirst()
            .get();

        return cars.stream()
            .filter(car -> car.getDistance() == maxPosition)
            .collect(Collectors.toList());
    }

    public static void tryOneRound(List<Car> cars) {
        for (Car car : cars) {
            car.tryRound();
        }
    }
}
