package racingcar.domain.game;

import java.util.List;

public class GameResult {
    private static final int PHASE_NUMBER_UNDER_BOUND = 1;
    private final int numberOfPhase;
    private List<PhaseResult> phaseResults;

    public GameResult(int numberOfPhase, List<PhaseResult> phaseResults) {
        this.numberOfPhase = numberOfPhase;
        this.phaseResults = phaseResults;
    }

    public int getNumberOfPhase() {
        return numberOfPhase;
    }

    public PhaseResult findByPhaseNumber(int phaseNumber) {
        validatePhaseNumber(phaseNumber);
        PhaseResult findPhaseResult = phaseResults.get(phaseNumber - 1);
        return new PhaseResult(findPhaseResult.getRaceResult());
    }

    private void validatePhaseNumber(int phaseNumber) {
        if (phaseNumber < PHASE_NUMBER_UNDER_BOUND || phaseNumber > numberOfPhase) {
            throw new IllegalArgumentException(String.format("잘못된 시도 번호입니다. - %d\n", phaseNumber));
        }
    }
}
