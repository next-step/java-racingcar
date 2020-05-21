package racingcar.race;

import racingcar.util.CommonUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarsJoinRacing {
    private static final String SPLIT_REGEX = ",";

    private final List<Car> cars;

    private CarsJoinRacing(String nameString) {
        CommonUtil.checkNullEmpty(nameString);
        String[] splitCars = nameString.split(SPLIT_REGEX);

        cars = Collections.unmodifiableList(createCarList(splitCars));
    }

    public static CarsJoinRacing newInstance(String nameString) {
        return new CarsJoinRacing(nameString);
    }

    private List<Car> createCarList(String[] splitCarNames) {
        return Arrays.stream(splitCarNames)
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

    public List<RacingScoreCard> getWinner() {
        final int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition).get();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> new RacingScoreCard(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<RacingScoreCard> getRaceResult() {
        return cars.stream().map(car ->
                new RacingScoreCard(car.getName(), car.getPosition())).collect(Collectors.toList());
    }

    public void race(RacingRule racingRule) {
        for(Car car : cars) {
            car.drive(racingRule.getMoveForward());
        }
    }
}
