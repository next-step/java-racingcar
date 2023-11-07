package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleRacingCarGame {

        private final int carCount;
        public SimpleRacingCarGame(int carCount) {
                this.carCount = carCount;
        }

        public List<Car> joinCars() {
                return IntStream.range(0, carCount).mapToObj(id -> new Car())
                        .collect(Collectors.toList());
        }

        public void moveOneRound(List<Car> cars) {
                cars.forEach(Car::movedForwardIfCan);
        }

}