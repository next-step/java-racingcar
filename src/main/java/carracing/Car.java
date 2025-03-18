package carracing;

public class Car {
    public static final int CAR_MOVING_BOUND = 4;
    private String name;
    private int distance = 1;
    private String distanceString;

    public Car(String name) {
        this.name = name;
        distanceString = name + " : -";
    }

    public void move(int randomNum) {
        if (randomNum >= CAR_MOVING_BOUND) {
            distance++;
            distanceString += "-";
        }
    }

    public String getDistanceString() {
        return distanceString;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
