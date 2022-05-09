package racingcarwinnerrefactor.domain;

import racingcarwinnerrefactor.exception.NullOrEmptyException;
import racingcarwinnerrefactor.util.MoveStrategy;
import racingcarwinnerrefactor.util.NameSplitUtil;
import racingcarwinnerrefactor.util.Strategy;
import racingcarwinnerrefactor.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipatedCars {

    public static final int WINNER_MIN_POSITION = 1;
    public static final String NEXT_LINE = "\n";
    public static final String DELIMITER = ",";
    public static final Strategy moveStrategy = new MoveStrategy();
    private final List<Car> cars;
    private static ParticipatedCars participatedCars;

    public static ParticipatedCars participatedCarsFactory() {
        if(participatedCars == null)  participatedCars = new ParticipatedCars(InputView.inputCarNames());
        return participatedCars;
    }

    private ParticipatedCars(String names) {
        String[] carNames = splitName(names);
        cars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    private ParticipatedCars(List<Car> cars) {
        this.cars = cars;
    }

    private static void assertNotBlank(String names) {
        if(names.isBlank()) throw new NullOrEmptyException();
    }

    public String[] splitName(String names) {
        assertNotBlank(names);
        return names.split(DELIMITER);
    }

    public final List<Car> findWinnerList() {
        Position maxPosition = findMaxPosition();

        return cars.stream().filter(car -> car.isMaxPosition(maxPosition)).collect(Collectors.toList());
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position(WINNER_MIN_POSITION);
        for(Car car : cars) {
            maxPosition = car.findMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public void moveAllCars() {
        cars.forEach(car -> car.move(moveStrategy));
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        cars.forEach(car -> out.append(car).append(NEXT_LINE));
        return out.toString();
    }

}
