package step3.domain;

public class Car {

    private static Integer currentLocation;

    public Car() {
        final Integer startLocation = 1;
        currentLocation = startLocation;
    }

    public void moveCar(Boolean isMove) {
        
    }

    public Integer getCurrentLocation() {
        return currentLocation;
    }
}
