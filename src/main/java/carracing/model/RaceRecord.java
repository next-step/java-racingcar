package carracing.model;

import java.util.List;

public class RaceRecord {
    private final List<Integer> positionOfCarList;
    private final boolean isLastAttempt;

    public RaceRecord(List<Integer> positionOfCarList, boolean isLastAttempt) {
        this.positionOfCarList = positionOfCarList;
        this.isLastAttempt = isLastAttempt;
    }

    public List<Integer> positionOfCarList() {
        return positionOfCarList;
    }

    public boolean isLastAttempt() {
        return isLastAttempt;
    }
}
