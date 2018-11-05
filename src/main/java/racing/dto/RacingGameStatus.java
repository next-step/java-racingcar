package racing.dto;

import java.util.List;

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
        int maxValue = getMaxPositionValue();
        return findMaxPositionCarNames(maxValue);
    }

    private void validateRacingCarStatuses() {
        if (racingCarStatuses.size() <= 0) {
            throw new IllegalStateException("대상 자동차가 존재하지 않습니다.");
        }
    }

    private int getMaxPositionValue() {
        return racingCarStatuses.stream()
                .mapToInt(RacingCarStatus::getPosition)
                .max().orElse(0);
    }

    private List<String> findMaxPositionCarNames(int maxValue) {
        return racingCarStatuses.stream()
                .filter(r -> r.getPosition() == maxValue)
                .map(RacingCarStatus::getName)
                .collect(toList());
    }
}
