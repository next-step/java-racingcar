package race.domain;

import race.utils.PlayStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> goForward(PlayStrategy rule) {
        for (Car car : this.cars) {
            goForwardWith(rule, car);
        }
        return Collections.unmodifiableList(this.cars);
    }

    public List<Car> findWinner() {
        return findWinnerHaving(max());
    }

    private void goForwardWith(PlayStrategy rule, Car car) {
        if (rule.isValidForGoForward()) {
            car.go();
        }
    }

    private List<Car> findWinnerHaving(int max) {
        return cars.stream()
                .filter(car -> car.isWinner(max))
                .collect(Collectors.toUnmodifiableList());
    }

    private int max() {
        int max = 0;
        for (Car car : cars) {
            max = car.maxComparedTo(max);
        }
        return max;
    }

}
