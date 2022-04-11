package racingcar;

public class Rule {
    private final int countOfCar;
    private final int maxAttempts;

    public Rule(int countOfCar, int maxAttempts) {
        this.countOfCar = countOfCar;
        this.maxAttempts = maxAttempts;
    }

    public int getCountOfCar() {
        return countOfCar;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}
