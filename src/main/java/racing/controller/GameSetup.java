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
        List<String> winnerList = new ArrayList<>();
        int highestDistance = 0;

        for (Car car: cars) {
            highestDistance = car.presentHigherDistance(highestDistance);
        }

        int finalHighestDistance = highestDistance;
        cars.stream()
            .filter(car -> car.distance().isEqual(finalHighestDistance))
            .forEach(car -> {
                winnerList.add(car.name());
            });

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