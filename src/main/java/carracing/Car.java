package carracing;

public class Car {
    private int distance = 1;
    private String distanceString = "-";

    public void move(int randomNum) {
        if (randomNum >= 4) {
            distance++;
            distanceString += "-";
        }
    }

    public String getDistanceString() {
        return distanceString;
    }
}
