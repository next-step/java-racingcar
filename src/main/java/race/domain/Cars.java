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

    private void goForwardWith(PlayStrategy rule, Car car) {
        if (rule.isValidForGoForward()) {
            car.go();
        }
    }

    //todo: 자동차 우승자 찾기
    public List<Car> findWinner() {
        int max = 0;
        for (Car car : cars) {
            max = car.maxComparedTo(max);
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(max)) {
                winners.add(car);
            }
        }
        return winners;
    }

}
