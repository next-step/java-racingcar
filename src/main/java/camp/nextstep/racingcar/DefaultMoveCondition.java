package camp.nextstep.racingcar;

import java.util.Random;

public class DefaultMoveCondition implements MoveCondition {

    private static final Random RANDOM = new Random();

    @Override
    public boolean satisfied() {
        int randomNumber = RANDOM.nextInt(10);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}
