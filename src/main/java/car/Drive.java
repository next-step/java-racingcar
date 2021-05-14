package car;

import java.util.ArrayList;
import java.util.List;

public class Drive {
    private static final int MAXIMUM_RANDOM_NUMBER = 10;
    private List<Car> cars;

    public Drive(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> carDrive() {
        Copy copy = new Copy(cars);

        List<Car> copiedCars = copy.createCopiedCars();

        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = (int) (Math.random() * MAXIMUM_RANDOM_NUMBER);

            copiedCars.get(i).changeKm(copiedCars.get(i).getKm() + randomNumber);
            cars.get(i).changeKm(cars.get(i).getKm() + randomNumber);
        }

        return copiedCars;
    }

    List<RaceResult> carRacing(int count) {
        int nowCount = 0;

        List<RaceResult> raceResults = new ArrayList<>();

        while (nowCount < count) {
            List<Car> drivedCars = carDrive();

            RaceResult raceResult = new RaceResult(drivedCars);

            raceResults.add(raceResult);

            nowCount++;
        }

        return raceResults;
    }
}
