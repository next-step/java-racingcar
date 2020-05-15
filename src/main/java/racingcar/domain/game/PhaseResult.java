package racingcar.domain.game;

import racingcar.domain.car.CarMoveResult;

import java.util.List;
import java.util.stream.Collectors;

public class PhaseResult {
    private List<CarMoveResult> raceResult;

    public PhaseResult(List<CarMoveResult> raceResult) {
        this.raceResult = raceResult;
    }

    public List<CarMoveResult> getRaceResult() {
        return raceResult;
    }

    public List<String> findPhaseLeads() {
        int leadLocation = raceResult.stream()
                .mapToInt(CarMoveResult::getLocation)
                .max()
                .orElseThrow(IllegalAccessError::new);

        return raceResult.stream()
                .filter(raceResult -> raceResult.getLocation() == leadLocation)
                .map(CarMoveResult::getName)
                .collect(Collectors.toList());
    }
}
