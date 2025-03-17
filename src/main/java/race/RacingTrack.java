package race;

import java.util.ArrayList;
import java.util.List;

public class RacingTrack {
    private final List<RacingCar> cars;
    private final int numOfAttempts;

    public RacingTrack(int numOfCars, int numOfAttempts) {
        this.numOfAttempts = numOfAttempts;
        this.cars = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            cars.add(new RacingCar(i, new DefaultRandomNumberGenerator()));
        }
    }

    public void startRace() {
        System.out.println("### Racing Start!!! ###");
        for (int i = 0; i < numOfAttempts; i++) {
            moveAndShowCars();
            System.out.println();
        }
    }

    private void moveAndShowCars() {
        for (RacingCar car : cars) {
            car.move();
            car.printPosition();
        }
    }
}
