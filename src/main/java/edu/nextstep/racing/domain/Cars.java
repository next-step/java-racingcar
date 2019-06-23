package edu.nextstep.racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 14:33
 */
public class Cars {
    private static final int RANDOM_NUMBER_RANGE = 9;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(CarNames names) {
        return new Cars(names.getNames().stream()
                .filter(s -> !"".equals(s.trim()))
                .distinct()
                .map(s -> new Car(s))
                .collect(Collectors.toList()));
    }

    public Cars doMoveGame() {
        List<Car> newCarList = new ArrayList<>();
        for (Car car : this.cars) {
            newCarList.add(car.carMove(validMoveNumber()));
        }
        return new Cars(newCarList);
    }

    public List<Integer> getCarsPosition() {
        return this.cars.stream()
                .map(Car::getCarPosition)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.cars.size();
    }

    public Stream<Car> stream() {
        return this.cars.stream();
    }

    public List<Car> asList() {
        return this.cars.stream()
                .collect(Collectors.toList());
    }

    private int validMoveNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
