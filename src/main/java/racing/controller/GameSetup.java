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