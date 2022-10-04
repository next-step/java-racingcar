package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameLogStore {

    private final List<String> logs = new ArrayList<>();

    public void store(String log) {
        this.logs.add(log);
    }

    public List<String> getLogs() {
        return Collections.unmodifiableList(logs);
    }
}
