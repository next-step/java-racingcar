package racingcar.model.racing;

public class Round {
    private final int total;
    private int current;

    public Round(int totalRound) {
        if (totalRound <= 0) {
            throw new IllegalArgumentException("Total round must be positive: " + totalRound);
        }
        this.total = totalRound;
    }

    public void next() {
        if (isOver()) {
            throw new IllegalStateException("round is over");
        }
        this.current++;
    }

    public int current() {
        return this.current;
    }

    public boolean isOver() {
        return this.total == current;
    }
}
