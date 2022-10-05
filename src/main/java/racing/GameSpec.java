package racing;

import util.RandomNumber;

public class GameSpec {

    private final int movementCondition;
    private final int randomMovementBound;

    private GameSpec() {
        this.movementCondition = 4;
        this.randomMovementBound = 9;
    }

    public static GameSpec createSimpleRacingCarSpec() {
        return new GameSpec();
    }

    public int movableCount() {
        if(generateMoveCount() >= movementCondition) {
            return 1;
        }
        return 0;
    }

    private int generateMoveCount() {
        return RandomNumber.generate(randomMovementBound);
    }

}
