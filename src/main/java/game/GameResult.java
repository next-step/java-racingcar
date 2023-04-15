package game;

import java.util.Collections;
import java.util.List;

public class GameResult {
    private final List<Integer> result;

    public GameResult(List<Integer> result) {
        this.result = result;
    }

    public List<Integer> getResult() {
        return Collections.unmodifiableList(result);
    }
}
