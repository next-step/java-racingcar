package carracing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RoundRecord {

    public static final String NON_NULL_CAR_STATUSES = "carStatuses 리스트 입력값은 null 일 수 없습니다";
    public static final String NOT_EMPTY_CAR_STATUSES = "carStatuses 리스트 입력값은 비어있을 수 없습니다";

    private final List<CarStatus> carStatuses;
    private final List<String> bestCarNames;

    public RoundRecord(List<CarStatus> carStatuses) {
        validateRecords(carStatuses);
        this.carStatuses = carStatuses;
        this.bestCarNames = findBestCarNames();
    }

    public List<CarStatus> getCarStatuses() {
        return Collections.unmodifiableList(carStatuses);
    }

    public List<String> getBestCarNames() {
        return Collections.unmodifiableList(bestCarNames);
    }

    private List<String> findBestCarNames() {
        int bestPosition = getMaxCarPosition();

        return carStatuses.stream()
                .filter(carStatus -> isBestCar(carStatus, bestPosition))
                .map(CarStatus::getName)
                .collect(Collectors.toList());
    }

    private boolean isBestCar(CarStatus carStatus, int bestPosition) {
        return carStatus.isEqualToPosition(bestPosition);
    }

    private int getMaxCarPosition() {
        return Collections.max(getCarPositions());
    }

    private List<Integer> getCarPositions() {
        return carStatuses.stream()
                .map(CarStatus::getPosition)
                .collect(Collectors.toList());
    }

    private void validateRecords(List<CarStatus> carStatuses) {
        requireNonNull(carStatuses);
        requireNotEmpty(carStatuses);
    }

    private void requireNonNull(List<CarStatus> carStatuses) {
        if (Objects.isNull(carStatuses)) {
            throw new IllegalArgumentException(NON_NULL_CAR_STATUSES);
        }
    }

    private void requireNotEmpty(List<CarStatus> carStatuses) {
        if (carStatuses.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_CAR_STATUSES);
        }
    }
}
