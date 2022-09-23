package racingcar.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public static final String DELIMITER = ",";
    private List<Car> elements = new ArrayList<>();

    public static Cars of(String carNames) {
        List<Car> cars = Stream.of(splitName(carNames))
                .map(Car::new)
                .collect(Collectors.toList());

        return Cars.of(cars);
    }

    private static String[] splitName(String carNames) {
        return carNames.split(DELIMITER);
    }

    public static Cars of(Collection<Car> elements) {
        return new Cars(new ArrayList<>(elements));
    }

    public static Cars of(List<Car> elements) {
        return new Cars(elements);
    }

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.elements = cars;
    }

    public List<Car> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public int size() {
        return elements.size();
    }

    public Cars findWinners() {
        Position maxPosition = getMaxPosition();
        return getCarsSamePosition(maxPosition);
    }

    private Cars getCarsSamePosition(Position position) {
        return Cars.of(elements.stream()
                .filter(car -> car.isSamePosition(position))
                .collect(Collectors.toList()));
    }

    private Position getMaxPosition() {
        return elements.stream()
                .map(Car::position)
                .max((p1, p2) -> p1.compare(p1, p2))
                .orElseThrow(NoSuchElementException::new);
    }

    public void add(Car car) {
        elements.add(car);
    }

    public void move(MoveStrategy moveStrategy) {
        elements = elements.stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList());
    }
}
