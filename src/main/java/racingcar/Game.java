package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final int repeat;
    private List<Car> cars;

    public Game(String[] names, int repeat) {
        this.repeat = repeat;
        initCars(names);
    }

    private void initCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
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
                .map(car -> new LaneViewModel(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
        ResultView.printRoundResult(lanes);
    }

    public List<Car> getCars() {
        return cars;
    }
}
