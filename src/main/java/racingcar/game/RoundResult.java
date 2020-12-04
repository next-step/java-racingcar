package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {
    private List<CarStatus> carStatuses;

    private RoundResult(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public static RoundResult newInstance(List<CarStatus> carStatuses) {
        return new RoundResult(carStatuses);
    }

    public int maxPosition() {
        return carStatuses.stream()
                .map(CarStatus::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    public List<String> determineWinners(int winnerPosition) {
        return carStatuses.stream()
                .filter(carStatus -> carStatus.equalsPosition(winnerPosition))
                .map(CarStatus::getCarName)
                .collect(Collectors.toList());
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }
}
