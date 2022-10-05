package racing_game.domain;

import racing_game.core.Positive;

public interface Moving {

    void move();
    Positive getDistance();
}
