package study.step4;

public class Car {

    private String carName;
    private int location;

    private Car(String carName) {
        this.carName = carName;
        this.location = 0;
    }

    public static Car of(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(RacingGameError.CAR_NAME_LENGTH_OVER);
        }

        return new Car(carName);
    }

    public Car move() {
        location++;
        return this;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }
}
