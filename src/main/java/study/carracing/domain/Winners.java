package study.carracing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<String> names;

    public Winners() {
        this.names = new ArrayList<>();
    }

    public void addNames(List<Car> cars, int maxPosition) {
        names.addAll(cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList())
        );
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        return Arrays.toString(names.toArray());
    }
}
