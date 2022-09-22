package racingcar.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> elements = new ArrayList<>();

    public static Cars of(Collection<Car> values) {
        return new Cars(new ArrayList<>(values));
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

    public void add(Car car) {
        elements.add(car);
    }

    public void move(MoveStrategy moveStrategy) {
        elements = elements.stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList());
    }
}
