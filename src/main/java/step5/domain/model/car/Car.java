package step5.domain.model.car;

import step5.Constant;
import step5.strategy.MoveStrategy;

public interface Car {
    void go(MoveStrategy strategy);
    boolean allowMove(MoveStrategy strategy);
    int currentProgress();
    String getName();

    static void isValidName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Constant.ERROR_5OVER_NAME);
        }
    }
}
