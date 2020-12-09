package racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int END_NUMBER = 0;
    private final int DECREASE_NUMBER = 1;

    private int count;
    private int number;
    private int initNumber;

    private List<Car> cars;

    public RacingGame(int count, int number) {
        this.count = count;
        this.number = number;
        initNumber = count;

        cars = carList();
    }

    public boolean isNotEnd() {
        this.count -= DECREASE_NUMBER;

        if(count < END_NUMBER) {
            return false;
        }

        return true;
    }

    public Result move() {
        if(ready()) {
            return new Result(cars);
        }

        for (Car car : cars) {
            car.move();
        }

        return new Result(cars);
    }

    private boolean ready() {
        if(count == initNumber-DECREASE_NUMBER) {
            return true;
        }
        return false;
    }

    private List<Car> carList() {
        cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
