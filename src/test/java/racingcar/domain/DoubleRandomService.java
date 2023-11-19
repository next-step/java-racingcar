package racingcar.domain;

public class DoubleRandomService implements RandomService {
    private final int number;

    public DoubleRandomService(int number) {
        this.number = number;
    }

    @Override
    public int nextInt(int bound) {
        return number;
    }
}
