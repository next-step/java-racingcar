package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLog {
    private final List<RoundLog> roundLogs;

    private GameLog() {
        this.roundLogs = new ArrayList<>();
    }

    public static GameLog init() {
        return new GameLog();
    }

    public void recode(RoundLog roundLog) {
        roundLogs.add(roundLog);
    }

    public List<RoundLog> getRoundLogs() {
        return Collections.unmodifiableList(roundLogs);
    }
}
