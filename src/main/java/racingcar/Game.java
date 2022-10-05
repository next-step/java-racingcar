package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final int repeat;
    private List<Car> cars;

    public Game() {
        int count = InputView.requestInputCount();
        initCars(count);

        this.repeat = InputView.requestInputRepeat();
        ResultView.println();
    }

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
        List<LaneView> lanes = cars.stream()
                .map(car -> new LaneView(car.getPosition()))
                .collect(Collectors.toList());
        ResultView.printRoundResult(lanes);
    }
}
