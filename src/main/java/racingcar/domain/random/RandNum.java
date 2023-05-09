package racingcar.domain.random;

public class RandNum {
    private final int num;

    public RandNum(int num) {
        this.num = num;
    }

    public boolean isGreaterThan(int min) {
        return this.num >= min;
    }
}
