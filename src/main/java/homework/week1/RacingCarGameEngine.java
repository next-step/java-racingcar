package homework.week1;

public class RacingCarGameEngine {

    private static final int MIN_RUN_CONDITION_VALUE = 4;

    private int numbersOfRacing;
    private int[] carPositions;

    public RacingCarGameEngine(int numbersOfRacing, int[] carPositions) {
        this.numbersOfRacing = numbersOfRacing;
        this.carPositions = carPositions;
    }

    public int[] move() {
        // TODO 구현
        return null;
    }

    public int getNumbersOfRacing() {
        return this.numbersOfRacing;
    }

    public int[] getCarPositions() {
        return this.carPositions;
    }

    boolean checkRunCondition(int value) {
        if (value < MIN_RUN_CONDITION_VALUE) {
            return false;
        }
        return true;
    }

    int getRunCount(boolean isRun, int runCount) {
        if (isRun) {
            return ++runCount;
        }
        return runCount;
    }

}
