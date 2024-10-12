package racingcar.model.race;

public class Car {
    private static final int CAN_MOVING_FORWARD = 4;

    private final String name;
    private final MovingDistance movingDistance;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int movingDistance) {
        this.name = name;
        this.movingDistance = new MovingDistance(movingDistance);
    }

    public void move(int randomNumber) {
        boolean isCarMoved = false;

        if (randomNumber >= CAN_MOVING_FORWARD) {
            isCarMoved = true;
        }
        movingDistance.increase(isCarMoved);
    }

    public int longest(int longestMovingDistance) {
        return movingDistance.longest(longestMovingDistance);
    }

    public boolean isSame(int longestMovingDistance) {
        return movingDistance.isSame(longestMovingDistance);
    }

    public String getName() {
        return name;
    }

    public int getMovingDistance() {
        return movingDistance.getValue();
    }
}
