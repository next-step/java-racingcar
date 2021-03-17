package step4.model;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public int getDistance() {
        int distance = 0;
        if(getRandom() >= 4){
            distance = 1;
        }
        return distance;
    }

    public int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
