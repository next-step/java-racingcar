package step3.domain;

import step3.domain.rule.MoveRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        cars = Arrays.stream(carNames)
                .map(carName -> new Car(carName))
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public void moveAll(int roundTime, MoveRule moveRule) {
        cars.forEach(car -> car.move(roundTime, moveRule.canMove()));
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinnerNames() {
        int winnerDistance = getMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == winnerDistance)
                .map(car -> car.getName())
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private int getMaxDistance() {

        return cars.stream()
                .map(car -> car.getDistance())
                .max(Integer::compareTo)
                .get();
    }
}