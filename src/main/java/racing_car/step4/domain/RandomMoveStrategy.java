package racing_car.step4.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    
    private static final int MOVE_STANDARD_NUM = 4;
    private static final int RANDOM_MAX_NUMBER = 10;
    
    @Override
    public boolean isMove() {
        return randomNumber() >= MOVE_STANDARD_NUM;
    }
    
    private int randomNumber() {
        return new Random().nextInt(RANDOM_MAX_NUMBER);
    }
}
