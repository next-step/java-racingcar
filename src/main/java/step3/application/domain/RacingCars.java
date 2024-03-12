package step3.application.domain;

import java.util.List;

public class RacingCars {

    private final List<Car> cars;
    private final RandomFactory randomFactory;
    public static final int MOVE_THRESHOLD = 4;
    public static final String LOCATION_MARK = "-";

    public RacingCars(List<Car> cars) {
        this.cars = cars;
        this.randomFactory = new RandomFactory();
    }

    public void moveCars() {
        for (Car car : this.cars) {
            int location = car.move(canMove());
            printLocation(location);
        }
    }

    private boolean canMove() {
        return randomFactory.drawNumber() >= MOVE_THRESHOLD;
    }

    private void printLocation(int location) {
        String currentLocation = LOCATION_MARK.repeat(Math.max(0, location));
        System.out.println(currentLocation);
    }
}