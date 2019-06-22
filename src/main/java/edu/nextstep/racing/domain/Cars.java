package edu.nextstep.racing.domain;

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

    public static Cars of(List<String> names) {
        return new Cars(names.stream()
                .map(s -> new Car(s))
                .collect(Collectors.toList()));
    }

    public Cars doMoveGame() {
        return new Cars(cars.stream()
                .peek(car -> car.carMove(validMoveNumber()))
                .collect(Collectors.toList()));
    }

    public List<String> getCarNames() {
        return this.cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<Integer> getCarsPosition() {
        return this.cars.stream()
                .map(Car::getCarPosition)
                .collect(Collectors.toList());
    }

    public Stream<Car> stream() {
        return this.cars.stream();
    }

    private int validMoveNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
