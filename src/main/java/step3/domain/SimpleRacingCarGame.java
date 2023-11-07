package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleRacingCarGame {

        private final int carCnt;
        public SimpleRacingCarGame(int carCnt) {
                this.carCnt = carCnt;
        }

        public List<Car> joinCars() {
                return IntStream.range(0, carCnt).mapToObj(id -> new Car())
                    .collect(Collectors.toList());
        }

        public void moveOneRound(List<Car> cars) {
                cars.forEach(Car::moveForwardIfCan);
        }

}