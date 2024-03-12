package racing;

import java.util.Random;

public class Car {
    private static final int POINT_BOUND = 10;
    private static final int MOVABLE_LOWER_BOUND = 4;

    private String name;
    private int currentLocation;

    public Car(String name, int currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }


    public int getCurrentLocation() {
        return currentLocation;
    }

    public void drive() {
        this.move(createMovePoint());
    }

    public void move(int movePoint) {
        if (isMove(movePoint)) {
            currentLocation++;
        }
    }

    private static boolean isMove(int movePoint) {
        return movePoint >= MOVABLE_LOWER_BOUND;
    }

    private static int createMovePoint() {
        return new Random().nextInt(POINT_BOUND);
    }

    public String getName() {
        return name;
    }
}
