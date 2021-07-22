package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.vehicle.Car;
import racingcar.vehicle.CarFactory;
import racingcar.vehicle.Cars;
import racingcar.view.ResultView;

public class Game {

    private final int driveCount;

    private final Cars cars;

    public Game(String carNames, int driveCount) {
        List<Car> cars = Arrays.stream(carNames.split(","))
            .map(CarFactory::create)
            .collect(Collectors.toList());

        this.cars = new Cars(cars);
        this.driveCount = driveCount;
    }

    public void playingDrive() {
        cars.doDrive();
    }

    public void printProgress() {
        ResultView.pirntProgress(cars);
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
