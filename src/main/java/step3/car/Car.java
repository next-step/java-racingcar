package step3.car;

import step3.strategy.PrintMarkStrategy;

public interface Car {
    void go();
    boolean allowMove();
    int currentProgress();
}
