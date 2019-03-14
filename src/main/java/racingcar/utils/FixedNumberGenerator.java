package racingcar.utils;

public class FixedNumberGenerator implements NumberGenerator {
    int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generateNumber() {
        return number;
    }
}