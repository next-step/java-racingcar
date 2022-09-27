package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameLogStore {

    private final List<String> logs = new ArrayList<>();

    public void store(String log) {
        this.logs.add(log);
    }

    public List<String> getLogs() {
        return logs;
    }
}
