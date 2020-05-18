package racingcar.domain;

public class FixedNumberStrategy implements Strategy {
    @Override
    public int getNumber() {
        return 5;
    }
}
