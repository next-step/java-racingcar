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
        ResultView.printResultStart();
        for (int i = 0; i < repeat; i++) {
            round();
            printLanes();
        }
    }

    private void round() {
        cars.forEach(Car::go);
    }

    private void printLanes() {
        List<LaneViewModel> lanes = cars.stream()
                .map(car -> new LaneViewModel(car.getPosition()))
                .collect(Collectors.toList());
        ResultView.printRoundResult(lanes);
    }
}
