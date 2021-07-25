package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private final List<Boolean> moveCondition = new ArrayList<>();
    private static int MAXIMUM_TRY_COUNT;
    private static final int MINIMUM_BOUND = 4;

    public static Car of(int tryCount) {
        Car car = new Car();
        MAXIMUM_TRY_COUNT = tryCount;
        return car;
    }

    public void move() {
        for(int i=0; i<MAXIMUM_TRY_COUNT; i++){
            check();
        }
    }

    public List<Boolean> getMoveCondition () {
        return this.moveCondition;
    }

    public int getDistance(int round) {
        int currentDistance = 0;
        for(int i=0;i<round;i++){
            if(moveCondition.get(i)) {
                currentDistance++;
            }
        }
        return currentDistance;
    }

    public List<Integer> getDistances() {
        int currentDistance = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<moveCondition.size(); i++){
            if(moveCondition.get(i)) {
                currentDistance++;
            }
            list.add(currentDistance);
        }
        return list;
    }

    private void check() {
        if(movable()) {
            moveCondition.add(true);
            return;
        }
        moveCondition.add(false);
    }

    private boolean movable() {
        Random random = new Random();
        if (random.nextInt(10) >= MINIMUM_BOUND) {
            return true;
        }
        return false;
    }

    private Car() {

    }

}
