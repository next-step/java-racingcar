package racingcar.game;

import racingcar.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {
    private List<CarStatus> carStatuses;

    private RoundResult(Cars cars) {
        this.carStatuses = cars.snapshotStatus();
    }

    public static RoundResult newInstance(Cars cars) {
        return new RoundResult(cars);
    }

    public int maxPosition() {
        return carStatuses.stream()
                .map(CarStatus::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    public List<String> determineWinners(int winnerPosition) {
        return carStatuses.stream()
                .filter(carStatus -> winnerPosition == carStatus.getPosition())
                .map(CarStatus::getCarName)
                .collect(Collectors.toList());
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }
}
