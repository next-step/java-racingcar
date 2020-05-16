package racingcar.domain.game;

import java.util.Collections;
import java.util.List;

public class GameResult {
    private final List<PhaseResult> phaseResults;

    public GameResult(List<PhaseResult> phaseResults) {
        this.phaseResults = Collections.unmodifiableList(phaseResults);
    }

    public PhaseResult findByPhaseNumber(int phaseNumber) {
        try {
            return phaseResults.get(phaseNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못된 시도 번호입니다. - " + phaseNumber);
        }
    }

    public List<PhaseResult> getPhaseResults() {
        return phaseResults;
    }

    public List<String> findWinners() {
        int lastPhase = phaseResults.size() - 1;
        return phaseResults.get(lastPhase).findPhaseLeads();
    }
}
