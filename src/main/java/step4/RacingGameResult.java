package step4;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {

    private final List<CarStatus> carStatuses;

    private RacingGameResult(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public static RacingGameResult makeResult(Cars cars) {
        return new RacingGameResult(cars.getCars().stream()
                .map(CarStatus::of)
                .collect(Collectors.toList()));
    }

    public List<CarStatus> getCarStatuses() {
        return Collections.unmodifiableList(carStatuses);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return carStatuses.stream()
                .filter(carStatus -> maxPosition == carStatus.getPosition())
                .map(CarStatus::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carStatuses.stream()
                .mapToInt(CarStatus::getPosition)
                .max()
                .orElseThrow();
    }
}
