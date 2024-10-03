package racingcar;

import java.util.Random;

public class Movement {
    private static final int  MOVE_CONDITION = 4;
    int randomNumber =  new Random().nextInt();
    public boolean isMove() {
        return randomNumber >= MOVE_CONDITION;
    }
}
