package step5;

import step5.enums.MOVE;
import step5.interfaces.MoveStrategy;

public class RandomMoveStrategy implements MoveStrategy {
    public boolean movable() {
        int randomNumber = RandomNumberGenerator.getRandomNumberGenerator().getRandomInt();

        return MOVE.fromInt(randomNumber).equals(MOVE.GO);
    }
}
