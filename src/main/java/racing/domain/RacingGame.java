package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGame {

    private Cars cars;
    private final List<List<CarHistory>> raceHistories = new ArrayList<>();;

    public RacingGame() {
    }

    public void start() {
        try {
            final List<String> names = InputView.getCarNames();
            cars = new Cars(names);

            final TryNumber tryNumber = InputView.getTryNumber();
            startRacing(tryNumber);

            OutputView.printGameResult(raceHistories);
            OutputView.printWinners(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private void startRacing(final TryNumber tryNumber) {
        while (tryNumber.hasNextStep()) {
            raceHistories.add(cars.driveCars());
            tryNumber.nextStep();
        }
    }
}
