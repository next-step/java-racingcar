package step3.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<EachTryResult> eachTryResults;

    public GameResult() {
        this.eachTryResults = new ArrayList<>();
    }

    public void addTryResult(EachTryResult eachTryResult) {
        eachTryResults.add(eachTryResult);
    }

    public List<EachTryResult> getEachTryResults() {
        return eachTryResults;
    }
}
