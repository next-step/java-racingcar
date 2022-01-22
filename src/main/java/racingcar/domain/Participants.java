package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class Participants {

    private final String[] carNames;
    private List<Car> cars = new ArrayList<>();

    public Participants(String[] names) {
        this.carNames = names;
        createCars();
    }

    private void createCars() {
        for (String name : this.carNames) {
            Car car = Car.from(name);
            cars.add(car);
        }
    }

    public List<Car> getParticipants() {
        return this.cars;
    }

    public int getParticipantCount() {
        return cars.size();
    }
}
