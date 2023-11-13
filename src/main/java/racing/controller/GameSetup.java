package racing.controller;

import racing.domain.Car;
import racing.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class GameSetup {
    private List<Car> cars = new ArrayList<>();
    private int round;

    public GameSetup(int round, List<String> names) {
        this.round = round;
        assignCarName(names);
    }

    public List<String> presentWinners() {
        int highestDistance = 0;
        List<String> winnerList = new ArrayList<>();

        for (Car car: cars) {
            if (car.isThisWinningWithOthers(highestDistance)) {
                winnerList.add(car.name());
                highestDistance = car.presentHigherDistance(highestDistance);
            }

            if (car.isThisWinningAlone(highestDistance)) {
                winnerList.clear();
                winnerList.add(car.name());
                highestDistance = car.presentHigherDistance(highestDistance);
            }
        }
        return winnerList;
    }

    private void assignCarName(List<String> names) {
        names.forEach(name -> {
            Car car = new Car(name);
            cars.add(car);
        });
    }

    public int round() {
        return round;
    }

    public List<Car> cars() {
        return cars;
    }

    public void moveCar() {
        for (Car car: cars) {
            car.validateForMove(RandomUtil.returnRandomNumber());
        }
    }
}