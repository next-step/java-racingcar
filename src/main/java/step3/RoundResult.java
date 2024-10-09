package step3;

import java.util.List;

public class RoundResult {

    private final List<Integer> roundResult;

    public RoundResult(List<Integer> roundResult) {
        this.roundResult = roundResult;
    }

    public int getSize() {
        return roundResult.size();
    }

    public int getCarDistance(int index) {
        return roundResult.get(index);
    }
}
