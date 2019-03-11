package racing.infrastructure;

import racing.application.Game;

import java.util.Random;

public class RandomGame implements Game {
    private final int BOUND = 9;
    private final int CONDITION = 4;

    @Override
    public boolean win() {
        return new Random().nextInt(BOUND) >= CONDITION;
    }
}
