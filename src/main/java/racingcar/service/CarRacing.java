package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RaceRecord;
import racingcar.model.RaceWinner;

import java.util.*;

public class CarRacing {

    private List<Car> cars;
    private static final int canMovingForward = 4;

    public CarRacing(String[] carNames) {
        carRaceReady(carNames);
    }

    private void carRaceReady(String[] carNames) {
        cars = new ArrayList<Car>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<RaceRecord> carRaceStart() {
        List<RaceRecord> records = new ArrayList<>();

        for(Car car : cars) {
            car.move(isCarMovingForward());
            records.add(new RaceRecord(car.getName(), car.getMovingDistance()));
        }

        return records;
    }

    public RaceWinner decideCarRaceWinner(List<RaceRecord> records) {
        return new RaceWinner(records);
    }

    public boolean isCarMovingForward() {
        Random random = new Random();
        int randomNumber = random.nextInt(9) + 1;

        return randomNumber >= canMovingForward;
    }

    public List<Car> getCars() {
        return cars;
    }
}

