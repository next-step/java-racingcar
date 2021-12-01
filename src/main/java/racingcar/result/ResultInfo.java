package racingcar.result;

import java.util.ArrayList;
import java.util.List;

public class ResultInfo {
    private List<Integer> results;

    public ResultInfo() {
        this.results = new ArrayList<>();
    }

    public void addResult(int carPosition) {
        this.results.add(carPosition);
    }

    public List<Integer> getResults() {
        return this.results;
    }
}
