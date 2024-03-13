package racingcar.util;

public abstract class AbstractRandomNumber {

    private final int number;

    public AbstractRandomNumber(int number) {
        this.number = number;
    }

    public boolean isMoreThan(int comparisonNumber) {
        return comparisonNumber <= number;
    }

    public boolean isLessThan(int comparisonNumber) {
        return comparisonNumber >= number;
    }

}
