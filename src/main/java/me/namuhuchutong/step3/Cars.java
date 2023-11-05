package me.namuhuchutong.step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    public static final String NEWLINE = "\n";

    private final List<Car> carList;

    public static Cars createCars(int numberOfCars) {
        validateNumberOfCars(numberOfCars);
        List<Car> collect = IntStream.range(0, numberOfCars)
                                     .mapToObj(i -> new Car())
                                     .collect(Collectors.toList());
        return new Cars(collect);
    }

    private static void validateNumberOfCars(int numberOfCars) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("자동차 수는 음수이거나 0일 수 없습니다. - " + numberOfCars);
        }
    }

    private  Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Cars raceAllCars(RacingRule racingRule) {
        this.carList.forEach(car -> car.move(racingRule.isSatisfiedRule()));
        return new Cars(copyOf(carList));
    }

    private List<Car> copyOf(List<Car> carList) {
        return carList.stream()
                      .map(Car::from)
                      .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder carPositions = new StringBuilder();
        buildCarPositions(carPositions);
        return carPositions.toString();
    }

    private void buildCarPositions(StringBuilder carPositions) {
        this.carList.forEach(car -> {
            String carPosition = car.getPositionToString();
            carPositions.append(carPosition).append(NEWLINE);
        });
    }
}
