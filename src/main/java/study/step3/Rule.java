package study.step3;

public class Rule {

    private final int numberOfCars;
    private final int movingTimes;

    public Rule(int racingLines, int movingTimes) {
        this.numberOfCars = racingLines;
        this.movingTimes = movingTimes;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getMovingTimes() {
        return movingTimes;
    }
}
