package racing.controller;

import racing.domain.Car;
import racing.util.RandomUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameSetup {
    private static List<Car> cars = new ArrayList<>();
    private int round;

    public GameSetup(int round, List<String> names) {
        this.round = round;
        assignCarName(names);
    }

    public List<String> validateWinner() {
        int highestDistance = cars.stream()
                .max(Comparator.comparing(car -> car.getDistance()))
                .get()
                .getDistance();
        List<String> winnerList = new ArrayList<>();

        cars.forEach(car -> {
            if (car.getDistance() == highestDistance) {
                winnerList.add(car.name());
            }
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
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).validateForMove(RandomUtil.returnRandomNumber());
        }
    }
}