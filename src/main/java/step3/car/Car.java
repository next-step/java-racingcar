package step3.car;

import step3.game.RacingGame;

public interface Car {
    void go(RacingGame game);

    default boolean allowMove(Integer number) {
        return number >= 4;
    }
}
