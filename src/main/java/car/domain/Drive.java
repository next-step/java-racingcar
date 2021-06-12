package car.domain;

import java.util.List;

public class Drive {
    private static final int MAXIMUM_RANDOM_NUMBER = 10;
    private Cars cars;

    public Drive(Cars cars) {
        this.cars = cars;
    }

    public List<Car> carDrive(MovableStrategy movableStrategy) {
        for (Car car : cars.getCars()) {
            car.moveOrStopCar(movableStrategy);
        }

        Copy copy = new Copy(cars);

        return copy.createCopiedCars();
    }

    public RaceResults carRacing(int count) {
        int nowCount = 0;

        RaceResults raceResults = new RaceResults();

        while (nowCount < count) {
            List<Car> drivedCars = carDrive(() -> (int) (Math.random() * MAXIMUM_RANDOM_NUMBER));

            RaceResult raceResult = new RaceResult(drivedCars);

            raceResults.addRaceResult(raceResult);

            nowCount++;
        }

        return raceResults;
    }
}
