import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Integer> advanceRound(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    car.advance();
                    return car.getNumberOfAdvance();
                })
                .collect(Collectors.toList());
    }

    private List<List<Integer>> race(List<Car> cars, int numberOfAttempts) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numberOfAttempts; i++) {
            result.add(advanceRound(cars));
        }
        return result;
    }

    public void start() {
        InputView inputView = new InputView();
        int numberOfCars = inputView.inputIntArgument("자동차 대수는 몇 대 인가요?");
        int numberOfAttempts = inputView.inputIntArgument("시도할 회수는 몇 회 인가요?");

        List<Car> cars = new CarFactory(numberOfCars).generateCars();

        List<List<Integer>> result = race(cars, numberOfAttempts);
        ResultView resultView = new ResultView(result);
        resultView.showRace();
    }
}
