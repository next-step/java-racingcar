package racing;

import java.util.Comparator;
import java.util.Random;

public class Car implements Comparator<Car> {
    private static final int RANDOM_BOUND = 9;
    private static final int TARGET_NUMBER = 4;

    //FIXME: 도메인에서 UI로직 제거.
    private static final String ROAD = "-";

    private int location = 0;

    public void move() {
        if (isPossibleToMove()) {
            location++;
        }
    }

    private boolean isPossibleToMove() {
        return doesRandomNumberAboveTargetNumber();
    }

    private boolean doesRandomNumberAboveTargetNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND) >= TARGET_NUMBER;
    }

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.location, o2.location);
    }

    public String location() {
        return ROAD.repeat(Math.max(0, location));
    }
}
