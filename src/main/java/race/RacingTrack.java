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
            cars.add(new RacingCar(i));
        }
    }

    public void start() {
        System.out.println("### Racing Start!!! ###");
        for (int i = 0; i < numOfAttempts; i++) {
            for (RacingCar car : cars) {
                car.move(RacingUtil.generateRandomNum());
                car.printPosition();
            }
            System.out.println();
        }
    }
}
