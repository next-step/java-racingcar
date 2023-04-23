package domain;

public class RacingCar {
    private static int nameSizeLimit = 5;
    private String name;
    private int distance;

    private static final int ONE_TIME_DISTANCE = 1;

    public RacingCar() {
    }
    public RacingCar(String name) {
        this.name = name;
    }

    public void moveOrStop(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.distance += ONE_TIME_DISTANCE;
        }
    }

    public int getDistance() {
        return distance;
    }

    public static boolean isNameValid(String name) {
        if (name.length() > nameSizeLimit) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return this.name + " : " + "-".repeat(this.distance);
    }
}
