package racingcar.game;

import org.apache.commons.lang3.StringUtils;
import racingcar.car.Car;
import racingcar.car.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Result {
    private List<Car> statusList;
    private int maxPosition;

    private Result(Cars cars) {
        this.statusList = cars.getCars();
        this.maxPosition = cars.getCars()
                .stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Result newInstance(Cars cars) {
        return new Result(cars);
    }

    public List<String> getStatusList() {
        return this.statusList
                .stream()
                .map(car -> createResultText(car))
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    private String createResultText(Car car) {
        return car.getName() + " : " + StringUtils.repeat("-", car.getPosition());
    }

    public List<String> determineWinners() {
        return statusList.stream()
                .filter(status -> this.maxPosition == status.getPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
