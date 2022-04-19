package step3.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<EachTryResult> eachTryResults;
    private List<String> winnerNames;

    public GameResult() {
        this.eachTryResults = new ArrayList<>();
    }

    public void addTryResult(EachTryResult eachTryResult) {
        eachTryResults.add(eachTryResult);
    }

    public void updateWinner() {
        EachTryResult eachTryResult = getLastTryResult();
        this.winnerNames = eachTryResult.getWinnerNames();
    }

    private EachTryResult getLastTryResult() {
        int lastTry = eachTryResults.size() - 1;
        return eachTryResults.get(lastTry);
    }

    public List<EachTryResult> getEachTryResults() {
        return eachTryResults;
    }

    public List<String> getWinnerNames() {
        return this.winnerNames;
    }
}
