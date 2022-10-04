package racingcar;

import static racingcar.util.RandomGenerator.randomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public Cars() {
    }

    public Cars(int number) {
        for (int i = 0; i < number; i++) {
            this.carList.add(new Car());
        }
    }

    public List<Car> carList() {
        return this.carList;
    }

    public void add() {
        this.carList.add(new Car());
    }

    public void add(int number) {
        for (int i = 0; i < number; i++) {
            this.carList.add(new Car());
        }
    }

    public void moveAll() {
        this.carList.forEach(car -> {
            car.move(randomNumber(10));
        });
    }

    public void clear() {
        this.carList.clear();
    }
}
