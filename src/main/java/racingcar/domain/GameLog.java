package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameLog {
    private final List<RoundLog> roundLogs;

    public GameLog() {
        this.roundLogs = new ArrayList<>();
    }

    public static GameLog init() {
        return new GameLog();
    }
}
