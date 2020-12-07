package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameReport {

    private final List<RoundReport> roundReports;

    public GameReport(final List<RoundReport> roundReports) {
        this.roundReports = new ArrayList<>(Collections.unmodifiableList(roundReports));
    }

    public static GameReport of(final List<RoundReport> roundReports) {
        return new GameReport(roundReports);
    }

    public List<RoundReport> getRoundReports() {
        return new ArrayList<>(roundReports);
    }

    public List<String> winner() {
        int lastRoundIndex = roundReports.size() - 1;
        return roundReports.get(lastRoundIndex)
                .winner();
    }
}
