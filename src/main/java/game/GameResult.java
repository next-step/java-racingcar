package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    private final List<List<Integer>> results;

    public GameResult() {
        this.results = new ArrayList<>();
    }

    public void add(List<Integer> result) {
        results.add(result);
    }

    public List<List<Integer>> getResults() {
        return Collections.unmodifiableList(results);
    }
}
