package racingcar.domain;


import racingcar.util.ResultDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int NOBODY_MOVE = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<ResultDto> getCurrentStatus() {
        return cars.stream()
                .map(ResultDto::new)
                .collect(Collectors.toList());
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
