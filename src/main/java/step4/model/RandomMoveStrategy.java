package step4.model;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean movable() {
        boolean movable = false;
        if(getRandom() >= 4){
           movable = true;
        }
        return movable;
    }

    public int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
