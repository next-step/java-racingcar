package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int repeat;
    private List<Car> cars;

    public Game(int count, int repeat) {
        this.repeat = repeat;
        initCars(count);
    }

    private void initCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    public void start() {
        ResultView.println("실행 결과");
        for (int i = 0; i < repeat; i++) {
            round();
        }
    }

    private void round() {
        cars.forEach(Car::go);
        print();
    }

    private void print() {
        ResultView.printRoundResult(cars);
    }
}
