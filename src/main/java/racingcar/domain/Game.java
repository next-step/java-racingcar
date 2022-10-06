package racingcar.domain;

import racingcar.view.LaneViewModel;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final ResultView resultView;
    private final int repeat;
    private List<Car> cars;

    public Game(String[] names, int repeat, ResultView resultView) {
        this.repeat = repeat;
        initCars(names);
        this.resultView = resultView;
    }

    private void initCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    public void start() {
        resultView.printStart();
        for (int i = 0; i < repeat; i++) {
            round();
            printLanes();
        }

        resultView.printWinner(getWinnerNames());
    }

    private void round() {
        cars.forEach(Car::go);
    }

    private void printLanes() {
        List<LaneViewModel> lanes = cars.stream()
                .map(car -> new LaneViewModel(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
        resultView.printRoundResult(lanes);
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
