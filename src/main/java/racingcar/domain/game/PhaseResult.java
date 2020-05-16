package racingcar.domain.game;

import racingcar.domain.car.CarMoveResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PhaseResult {
    private List<CarMoveResult> raceResult;

    public PhaseResult(List<CarMoveResult> raceResult) {
        this.raceResult = Collections.unmodifiableList(raceResult);
    }

    public List<CarMoveResult> getRaceResult() {
        return raceResult;
    }

    public List<String> findPhaseLeads() {
        int leadLocation = findLeadLocation();

        return raceResult.stream()
                .filter(raceResult -> raceResult.isSameLocation(leadLocation))
                .map(CarMoveResult::getName)
                .collect(Collectors.toList());
    }

    private int findLeadLocation() {
        return raceResult.stream()
                .mapToInt(CarMoveResult::getLocation)
                .max()
                .orElseThrow(() -> new IllegalStateException("경기 기록이 존재하지않습니다."));
    }
}
