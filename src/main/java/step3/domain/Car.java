package step3.domain;

public class Car {

    private final static int START_LOCATION = 1;
    private Integer currentLocation;

    public Car() {
        currentLocation = START_LOCATION;
    }

    public void moveCar(Boolean isMove) {
        currentLocation = isMove ? ++currentLocation : currentLocation;
    }

    public Integer getCurrentLocation() {
        return currentLocation;
    }

    public Car(Integer location) {
        currentLocation = location;
    }
}
