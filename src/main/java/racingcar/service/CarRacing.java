package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarRecord;

import java.util.*;

public class CarRacing {

    private List<Car> cars;

    public CarRacing() {}

    public CarRacing(int numberOfCars) {
        carRaceReady(numberOfCars);
    }

    private void carRaceReady(int numberOfCars) {
        makeCarsList(numberOfCars);
    }

    public List<CarRecord> carRaceStart() {
        List<CarRecord> records = new ArrayList<>();

        for(Car car : cars) {
            car.move(isCarMovingForward());
            CarRecord record = new CarRecord(car.getMovingDistance());
            records.add(record);
        }

        return records;
    }

    public void makeCarsList(int numberOfCars) {
        cars = new ArrayList<Car>();

        for(int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public boolean isCarMovingForward() {
        Random random = new Random();
        int randomNumber = random.nextInt(9) + 1;

            if(randomNumber >= 4)
                return true;

        return false;
    }

    public List<Car> getCars() {
        return cars;
    }
}

