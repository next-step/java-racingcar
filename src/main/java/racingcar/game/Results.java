package racingcar.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Results {
    private List<Result> results;

    private Results() {
        results = new ArrayList<>();
    }

    public static Results newInstance() {
        return new Results();
    }

    public void add(Result result) {
        this.results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> getWinners() {
        int lastStage = this.results.size() - 1;
        Result result = this.results.get(lastStage);
        return result.determineWinners();
    }
}
