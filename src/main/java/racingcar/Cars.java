package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    private Cars(Builder builder) {
        this.cars = IntStream
                .range(0, builder.carCount)
                .mapToObj(count -> Car.builder()
                        .rangeStartRandomNumber(builder.rangeStartRandomNumber)
                        .rangeEndRandomNumber(builder.rangeEndRandomNumber)
                        .moveCondition(builder.moveCondition)
                        .build())
                .collect(Collectors.toList());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int carCount;
        private int rangeStartRandomNumber;
        private int rangeEndRandomNumber;
        private int moveCondition;

        public Builder carCount(int carCount) {
            this.carCount = carCount;
            return this;
        }

        public Builder rangeStartRandomNumber(int rangeStartRandomNumber) {
            this.rangeStartRandomNumber = rangeStartRandomNumber;
            return this;
        }

        public Builder rangeEndRandomNumber(int rangeEndRandomNumber) {
            this.rangeEndRandomNumber = rangeEndRandomNumber;
            return this;
        }

        public Builder moveCondition(int moveCondition) {
            this.moveCondition = moveCondition;
            return this;
        }

        public Cars build() {
            return new Cars(this);
        }
    }

    public List<Car> getInstance() {
        return cars;
    }

    public void addMove() {
        cars.forEach(Car::addMoveCount);
    }
}
