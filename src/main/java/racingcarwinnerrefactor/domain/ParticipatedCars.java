package racingcarwinnerrefactor.domain;

import racingcarwinnerrefactor.Constants;
import racingcarwinnerrefactor.util.NameSplitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipatedCars {

    private final List<Car> cars;

    public ParticipatedCars(String names) {
        String[] carNames = NameSplitUtil.splitName(names);
        cars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public ParticipatedCars(List<Car> cars) {
        this.cars = cars;
    }

    public final List<Car> findWinnerList() {
        Position maxPosition = findMaxPosition();

        return cars.stream().filter(car -> car.isMaxPosition(maxPosition)).collect(Collectors.toList());
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position(Constants.WINNER_MIN_POSITION);
        for(Car car : cars) {
            maxPosition = car.findMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public void moveAllCars() {
        cars.forEach(car -> car.move(Constants.moveStrategy));
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        cars.forEach(car -> out.append(car).append(Constants.NEXT_LINE));
        return out.toString();
    }

}
