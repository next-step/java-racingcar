package carracing.domain.record;

import java.util.List;
import java.util.stream.Collectors;

public class RoundRecords {
    private final List<RoundRecord> roundRecords;

    private RoundRecords(List<RoundRecord> roundRecords) {
        this.roundRecords = roundRecords;
    }

    public static RoundRecords from(List<RoundRecord> roundRecords) {
        return new RoundRecords(roundRecords);
    }

    public List<RoundRecord> getRoundRecords() {
        return roundRecords.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> findWinners() {
        RoundRecord lastRound = roundRecords.get(roundRecords.size() - 1);
        return lastRound.getLeadingCarNames();
    }
}
