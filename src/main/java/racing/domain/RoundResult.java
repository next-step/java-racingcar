package racing.domain;

import java.util.List;

public class RoundResult {
    private final List<Integer> roundResult;

    public RoundResult(List<Integer> result) {
        this.roundResult = result;
    }

    public int totalResult() {
        return roundResult.size();
    }

    public Integer valueOfCarPosition(int i) {
        return roundResult.get(i);
    }
}
