package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGame {

    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    private final List<Car> cars;
    private List<List<CarHistory>> raceHistories;

    public RacingGame() {
        this.cars = new ArrayList<>();
    }

    public void start() {
        try {
            final List<String> names = InputView.getCarNames();
            for (String name : names) {
                cars.add(new Car(name));
            }
            checkCarCount(cars);

            final TryNumber tryNumber = InputView.getTryNumber();

            raceHistories = new ArrayList<>();
            startRacing(tryNumber);
            final int maxPosition = getMaxPosition();
            List<String> winners = getWinners(maxPosition);

            OutputView.printGameResult(raceHistories);
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    // 차들 관리
    private List<String> getWinners(final int maxPosition) {
        return cars.stream()
            .filter(car -> !Objects.isNull(car.getNameBy(maxPosition)))
            .map(car -> car.getName())
            .collect(Collectors.toList());
    }

    // 차들 관리
    private static void checkCarCount(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 최소 1대 이상의 자동차가 필요합니다.");
        }
    }

    private void startRacing(final TryNumber tryNumber) {
        while (tryNumber.nextStep()) {
            raceHistories.add(driveCars());
        }
    }

    // 차들 관리
    private List<CarHistory> driveCars() {
        final List<CarHistory> carHistories = new ArrayList<>();
        for (Car car : cars) {
            car.drive(generateRandomNumber());
            carHistories.add(new CarHistory(car.getName(), car.getPosition()));
        }
        return carHistories;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    // 차들 관리
    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
