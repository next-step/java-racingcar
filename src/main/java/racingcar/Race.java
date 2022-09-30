package racingcar;

import racingcar.util.RandomNumber;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Race {
    private static final List<Car> cars = new ArrayList<>();

    private Race(){}

    public static void ready(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public static List<Car> playRace() {
        for (Car car : cars) {
            car.move(RandomNumber.makeRandomNumber());
        }
        return cars;
    }

    public static List<Car> findWinners(List<Car> cars) {
        return getPositionEntrySet(cars)
                .stream().max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue();
    }

    private static Set<Map.Entry<Integer, List<Car>>> getPositionEntrySet(List<Car> cars) {
        return cars.stream().collect(groupingBy(Car::getPosition)).entrySet();
    }



}
