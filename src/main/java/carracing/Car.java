package carracing;

public class Car {
    private String name;
    private int distance = 1;
    private String distanceString;

    public Car(String _name) {
        name = _name;
        distanceString = name + " : -";
    }

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
