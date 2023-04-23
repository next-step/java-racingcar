package step5.domain;

public class Reps {

    public static final int ZERO = 0;

    private int reps;

    public Reps(int inputReps) {
        if (isNegativeNumberOrZero(inputReps)) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요.");
        }
        this.reps = inputReps;
    }

    private boolean isNegativeNumberOrZero(int inputReps) {
        return inputReps <= ZERO;
    }

    public boolean isOverZero() {
        return reps > ZERO;
    }

    public void repsDown() {
        reps--;
    }

    public int getReps() {
        return reps;
    }

    @Override
    public String toString() {
        return String.valueOf(reps);
    }
}
