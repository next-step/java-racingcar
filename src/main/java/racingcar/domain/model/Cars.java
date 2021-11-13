package racingcar.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.exception.HistoryOutOfBoundsException;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {

    private static final String DELIMITER = ",";

    private List<Car> cars;
    private int tryCountTotal = 0;

    private Cars(String[] names) {
        this.cars = Arrays.stream(names)
            .map(Car::from)
            .collect(Collectors
                .toCollection(ArrayList::new));
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String name) {
        String[] names = name.split(DELIMITER);
        return new Cars(names);
    }

    public long size() {
        return cars.size();
    }

    public void moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
        tryCountTotal++;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getTryCountTotal() {
        return tryCountTotal;
    }

    public Cars getWinners() {
        return new Cars(getWinners(getSuccessMax()));
    }

    private long getSuccessMax() {
        return cars.stream()
            .mapToLong(Car::getHistorySuccessCount)
            .max()
            .orElseThrow(HistoryOutOfBoundsException::new);
    }

    private List<Car> getWinners(long max) {
        return cars.stream()
            .filter(car -> car.getHistorySuccessCount() == max)
            .collect(Collectors
                .toCollection(ArrayList::new)
            );
    }

}
