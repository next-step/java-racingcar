package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }

    public void attempt() {
        cars.forEach(Car::attempt);
    }

    public List<Integer> getScores() {
        return cars.stream()
                .map(Car::getScore)
                .collect(Collectors.toList());
    }
}
