package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final int numberOfPhase;
    private List<PhaseResult> phaseResults;

    public GameResult(int numberOfPhase) {
        this.numberOfPhase = numberOfPhase;
        phaseResults = new ArrayList<>();
    }

    public int getNumberOfPhase() {
        return numberOfPhase;
    }

    public int addPhaseResult(PhaseResult phaseResult) {
        this.phaseResults.add(phaseResult);
        return this.phaseResults.size();
    }

    public PhaseResult findByPhaseNumber(int phaseNumber) {
        validatePhaseNumber(phaseNumber);
        PhaseResult findPhaseResult = phaseResults.get(phaseNumber - 1);
        return new PhaseResult(findPhaseResult.getRaceResult());
    }

    private void validatePhaseNumber(int phaseNumber) {
        if (phaseNumber < 1 || phaseNumber > numberOfPhase) {
            throw new IllegalArgumentException(String.format("잘못된 시도 번호입니다. - %d\n", phaseNumber));
        }
    }
}
