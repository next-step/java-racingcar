package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public void playRound(RandomNumber randomNumber) {
        for (Car car : cars) {
            car.move(new Torque(randomNumber.generate()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winners getWinners() {
        return Winners.from(cars);
    }
}
