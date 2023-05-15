package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void readyCar(String[] carsName) {
        for (String name : carsName) {
            cars.add(new Car(name));
        }
    }

    public void playGame() {
        RandomMoveForward randomMoveForward = new RandomMoveForward();
        for (Car car : cars) {
            car.move(randomMoveForward);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> winners() {
        WinnersCar winnersCar = new WinnersCar(cars);
        return winnersCar.winners();
    }

}
