package RacingCar;

public class Car {

    private String location;
    private final int minNumber;

    public Car(String location, int minNumber) {
        this.location = location;
        this.minNumber = minNumber;
    }

    public String location() {
        return location;
    }

    public String move(int num) {

        if (num >= minNumber)
            location += "-";

        return "";
    }
}
