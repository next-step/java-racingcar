package racingcar;

import java.util.Arrays;
import racingcar.vehicle.CarFactory;
import racingcar.vehicle.Cars;
import racingcar.view.ResultView;

public class Game {

    private final int driveCount;

    private final Cars cars = new Cars();

    public Game(String carNames, int driveCount) {
        Arrays.stream(carNames.split(","))
            .forEach(carName -> cars.add(CarFactory.create(carName)));
        this.driveCount = driveCount;
    }

    public void playingDrive() {
        cars.doDrive();
    }

    public void printProgress() {
        ResultView.pirntProgress(cars);
    }

    public void doGame() {
        for (int i = 0; i < driveCount; i++) {
            cars.doDrive();
            ResultView.pirntProgress(cars);
        }
    }

    public Cars getWinners() {
        int farthestDistance = cars.getFarthestDistance();

        if (farthestDistance == 0) {
            return cars;
        }

        return cars.findByDistance(farthestDistance);
    }

    public int getDriveCount() {
        return driveCount;
    }
}
