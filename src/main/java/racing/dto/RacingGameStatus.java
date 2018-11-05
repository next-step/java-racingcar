package racing.dto;

import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class RacingGameStatus {
    private List<RacingCarStatus> racingCarStatuses;

    public RacingGameStatus(List<RacingCarStatus> racingCarStatuses) {
        this.racingCarStatuses = racingCarStatuses;
    }

    public List<RacingCarStatus> getRacingCarStatuses() {
        return racingCarStatuses;
    }

    public List<String> getWinnerNames() {
        validateRacingCarStatuses();
        // 우선 가장 멀리간 차량을 찾는다.
        RacingCarStatus maxPositionRacingCar = getMaxPositionRacingCar();
        // 멀리간 포지션과 동일한 크기를 차량을 가져온다.
        return getSamePositionCarNames(maxPositionRacingCar);
    }

    private List<String> getSamePositionCarNames(RacingCarStatus maxPositionRacingCar) {
        return racingCarStatuses.stream()
                .filter(c -> 0 == maxPositionRacingCar.compareTo(c))
                .map(RacingCarStatus::getName)
                .collect(toList());
    }

    private void validateRacingCarStatuses() {
        if (racingCarStatuses.size() <= 0) {
            throw new IllegalStateException("대상 자동차가 존재하지 않습니다.");
        }
    }

    private RacingCarStatus getMaxPositionRacingCar() {
        return racingCarStatuses.stream()
                .max(naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("list의 값이 존재하지 않음"));
    }
}
