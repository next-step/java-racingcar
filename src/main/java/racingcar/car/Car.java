package racingcar.car;

public interface Car {
    void go();
    boolean allowMove();
    int currentProgress();
    String getName();
}
