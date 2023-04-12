package racingcar;

public class UserInput {

    private final Integer totalCarCount;
    private final Integer totalMoveCount;

    public UserInput(int totalCarCount, int totalMoveCount) {
        this.totalCarCount = totalCarCount;
        this.totalMoveCount = totalMoveCount;
    }

    public Race readyForRace() {
        return new Race(this.totalCarCount, this.totalMoveCount);
    }
}
