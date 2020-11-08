package racingcar;

import java.util.Random;

public class Car {
    public static final int LIMIT_BOUND = 10;
    public static final int MOVE_THRESHHOLD = 4;
    int distance = 1;

    public void go(){
        if(isMove(getRandom())) {
            distance++;
        }
    }

    public boolean isMove(int random){
        if(random >= MOVE_THRESHHOLD){
            return true;
        }
        return false;
    }

    public int getRandom(){
        Random random = new Random();
        return random.nextInt(LIMIT_BOUND);
    }

    public int getDistance() {
        return distance;
    }
}
