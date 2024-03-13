package racingcar;

import racingcar.model.Car;
import racingcar.ui.ResultView;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RacingCarGameRule {
    private static final int MOVE_CONDITION = 3;
    private static RacingCarGameRule instance = new RacingCarGameRule();

    private RacingCarGameRule() {

    }

    public static RacingCarGameRule getInstance() {
        return instance;
    }

    public void moveCars(List<Car> cars) {
        cars.stream().forEach(car -> car.move(isMovingForward(RandomManager.getInstance().getRandomValue())));
        ResultView.getInstance().printMove(cars);
        ResultView.getInstance().printLineBreak();
    }

    public boolean isMovingForward(int value) {
        return value > MOVE_CONDITION;
    }

    public List<Car> getWinnerCars(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        return cars.stream().filter(isMaxDistance(maxDistance)).collect(Collectors.toList());
    }

    private Predicate<? super Car> isMaxDistance(int maxDistance) {
        return car -> car.getDistance() == maxDistance;
    }

    private static int getMaxDistance(List<Car> cars) {
        return cars.stream().map(Car::getDistance).max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
    }

}
