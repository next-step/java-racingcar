package racingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Car[] cars;
    private int times;

    public RacingGame(int cars, int times) {
        createCars(cars);
        this.times = times;
    }

    private void createCars(int cars) {
        this.cars = new Car[cars];
        for (int i = 0; i < this.cars.length; i++) {
            this.cars[i] =  new Car();
        }
    }

    public List<Integer[]> start() {
        List<Integer[]> result = new ArrayList();
        for (int i = times; i > 0; i--) {
            result.add(move());
        }
        return result;
    }

    private Integer[] move() {
        Integer[] time = new Integer[cars.length];
        for (int j = 0; j < cars.length; j++) {
            cars[j].move();
            time[j] = cars[j].getPosition();
        }
        return time;
    }
}
