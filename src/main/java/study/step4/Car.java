package study.step4;

public class Car {

    private String carName;
    private int location;

    private Car(String carName) {
        this.carName = carName;
        this.location = 0;
    }

    public static Car of(String carName) {
        return new Car(carName);
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }
}
