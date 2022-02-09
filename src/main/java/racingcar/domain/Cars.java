package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {

    private static final String NOTNULL_MESSAGE = "빈값을 초기화할 수 없습니다.";
    private static final String NAME_DUPLICATE_MESSAGE = "자동차 이름이 중복되었습니다.";
    private static final String MAX_POSITION_MESSAGE = "최대 위치를 구할 수 없습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        verifyMinSize(cars);
        verifyDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    public static Cars of(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new RacingCar(name));
        }
        return new Cars(cars);
    }

    private void verifyMinSize(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalStateException(NOTNULL_MESSAGE);
        }
    }

    private void verifyDuplicate(List<Car> cars) {
        Set<Car> carNames = new HashSet<>(cars);

        if (carNames.size() != cars.size()) {
            throw new IllegalStateException(NAME_DUPLICATE_MESSAGE);
        }
    }

    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException(MAX_POSITION_MESSAGE));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
