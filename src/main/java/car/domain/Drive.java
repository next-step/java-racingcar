package car.domain;

import java.util.List;

public class Drive {
    private static final int MAXIMUM_RANDOM_NUMBER = 10;
    private Cars cars;

    public Drive(Cars cars) {
        this.cars = cars;
    }

    public List<Car> carDrive(MovableStrategy movableStrategy) {
        for (int i = 0; i < cars.getCars().size(); i++) {

            moveOrStopCar(movableStrategy, cars.getCars().get(i));
        }

        Copy copy = new Copy(cars);

        return copy.createCopiedCars();
    }

    public void moveOrStopCar(MovableStrategy movableStrategy, Car car) {
        car.changeKm(movableStrategy.getRandomNo());
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
