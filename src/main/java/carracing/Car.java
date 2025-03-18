package carracing;

public class Car {
    public static final int CAR_MOVING_BOUND = 4;
    private String name;
    private int distance = 1;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNum) {
        if (randomNum >= CAR_MOVING_BOUND) {
            distance++;
        }
    }

    public String getDistanceString() {
        String returnString = name + " : ";
        for (int i = 0; i < distance; ++i) {
            returnString += "-";
        }
        return returnString;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
