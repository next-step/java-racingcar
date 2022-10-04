package racing;

import util.RandomNumber;

public class GameSpec {

    private final int movementCondition;
    private final int randomMovementBound;

    public static GameSpec createSimpleRacingCarSpec() {
        return new GameSpec();
    }

    public int movableCount() {
        final int random = generateMoveCount();
        if(random >= movementCondition) {
            return random;
        }
        return 0;
    }

    private GameSpec() {
        this.movementCondition = 4;
        this.randomMovementBound = 9;
    }

    private int generateMoveCount() {
        return RandomNumber.generate(randomMovementBound);
    }

}
