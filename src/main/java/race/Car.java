package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private final List<Boolean> moveCondition = new ArrayList<>();
    private int maxTryCount;
    private static final int MINIMUM_BOUND = 4;

    private Car() {

    }

    private Car(int tryCount) {
        this.maxTryCount = tryCount;
    }

    public static Car of(int tryCount) {
        return new Car(tryCount);
    }

    public void move() {
        for (int i = 0; i < maxTryCount; i++) {
            moveCondition.add(movable());
        }
    }

    public List<Boolean> getMoveCondition() {
        return this.moveCondition;
    }

    public int getDistance(int round) {
        return (int) moveCondition.stream()
                .limit(round)
                .filter(i->i)
                .count();
    }

    private boolean movable() {
        Random random = new Random();
        return random.nextInt(10) >= MINIMUM_BOUND;
    }

}
