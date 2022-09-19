package racing_car.step3.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    
    @Override
    public boolean isMove() {
        return randomNumber() >= 4;
    }
    
    private int randomNumber() {
        return new Random().nextInt(10);
    }
}
