package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private static final int CHECK_CAR_COUNT = 0;
    private final List<Car> cars;
    private final RaceCondition raceCondition;

    private Cars(Builder builder) {
        this.cars = IntStream
                .range(0, builder.carCount)
                .mapToObj(count -> new Car())
                .collect(Collectors.toList());
        this.raceCondition = builder.raceCondition;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean checkSize() {
        return cars.size() > CHECK_CAR_COUNT;
    }

    public void addMove() {
        cars.forEach(car ->
                car.addMoveCount(raceCondition.generateCondition()));
    }

    public List<String> carsMoveState(String expression) {
        List<String> moveStates = new ArrayList<>();
        for (Car car : cars) {
            moveStates.add(car.moveCountExpression(expression));
        }

        return moveStates;
    }

    public static class Builder {
        private int carCount;
        private RaceCondition raceCondition;

        public Builder carCount(int carCount) {
            this.carCount = carCount;
            return this;
        }

        public Builder raceCondition(RaceCondition raceCondition) {
            this.raceCondition = raceCondition;
            return this;
        }

        public Cars build() {
            return new Cars(this);
        }
    }

}
