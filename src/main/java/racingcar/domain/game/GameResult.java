package racingcar.domain.game;

import java.util.Collections;
import java.util.List;

public class GameResult {
    private final int numberOfPhase;
    private final List<PhaseResult> phaseResults;

    public GameResult(int numberOfPhase, List<PhaseResult> phaseResults) {
        this.numberOfPhase = numberOfPhase;
        this.phaseResults = Collections.unmodifiableList(phaseResults);
    }

    public int getNumberOfPhase() {
        return numberOfPhase;
    }

    public PhaseResult findByPhaseNumber(int phaseNumber) {
        try {
            return phaseResults.get(phaseNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못된 시도 번호입니다. - " + phaseNumber);
        }
    }

    public List<String> findWinners() {

        return phaseResults.get(numberOfPhase - 1).findPhaseLeads();
    }
}
