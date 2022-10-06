package racingcar.domain;

import racingcar.view.LaneViewModel;
import racingcar.view.ResultView;

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

        printWinner();
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

    private void printWinner() {
        List<String> winnerNames = getWinnerNames();
        ResultView.printWinner(winnerNames);
    }

    private List<String> getWinnerNames() {
        int position = winnerPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int winnerPosition() {
        int max = 0;
        for (Car car: cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    public List<Car> getCars() {
        return cars;
    }
}
