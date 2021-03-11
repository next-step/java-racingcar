package racingcar.domain;

import racingcar.util.ResultView;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int NOBODY_MOVE = 0;

    private List<Car> cars;

    public Cars(String[] carNames) {
        cars = new LinkedList<>();
        for (String carName : carNames) {
            cars.add(new Car(new RandomEngine(), carName));
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public void showResult() {
        cars.forEach(ResultView::showResult);
        ResultView.printNewLine();
    }

    public List<String> getWinnerNames() {
        int winnerPosition = findWinnerPosition();
        List<String> winnerNames = findWinners(winnerPosition);
        return Collections.unmodifiableList(winnerNames);
    }

    private List<String> findWinners(int winnerPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(NOBODY_MOVE);
    }
}
