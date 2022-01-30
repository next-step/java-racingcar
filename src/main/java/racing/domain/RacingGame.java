package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGame {

    private Cars cars;
    private List<List<CarHistory>> raceHistories;

    public RacingGame() {
    }

    public void start() {
        try {
            final List<String> names = InputView.getCarNames();
            cars = new Cars(names);

            final TryNumber tryNumber = InputView.getTryNumber();
            raceHistories = new ArrayList<>();
            startRacing(tryNumber);

            final List<String> winners = getWinners(cars.getMaxPosition(), cars.getCars());
            OutputView.printGameResult(raceHistories);
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private List<String> getWinners(final int maxPosition, List<Car> cars) {
        return cars.stream()
            .filter(car -> !Objects.isNull(car.getNameBy(maxPosition)))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private void startRacing(final TryNumber tryNumber) {
        while (tryNumber.nextStep()) {
            raceHistories.add(cars.driveCars());
        }
    }
}
