package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
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
