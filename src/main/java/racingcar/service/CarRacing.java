package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RaceRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {
    private static final int CAN_MOVING_FORWARD = 4;

    private List<Car> cars;

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

        for (Car car : cars) {
            car.move(isCarMovingForward());
            records.add(new RaceRecord(car.getName(), car.getMovingDistance()));
        }

        return records;
    }

    public boolean isCarMovingForward() {
        Random random = new Random();
        int randomNumber = random.nextInt(9) + 1;

        return randomNumber >= CAN_MOVING_FORWARD;
    }

    public List<Car> getCars() {
        return cars;
    }
}

