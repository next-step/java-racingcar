package racingCar;

public class Car {

    private static final int BOUNDARY = 4;

    private String distance = "";

    public String move(int value) {
        if (value >= BOUNDARY) {
            this.distance += "-";
            return "-";
        }

        return "";
    }

    public String getDistance() {
        return this.distance;
    }
}
