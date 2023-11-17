package racingcar.model;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.model.movestrategy.MoveStrategy;

public class RacingCarGame {

        private final Cars cars;
        private final MoveStrategy moveStrategy;
        private int round;

        public RacingCarGame(int round, MoveStrategy moveStrategy, String[] carNames) {
                this.round = round;
                this.moveStrategy = moveStrategy;
                this.cars = joinCars(carNames);
        }

        public Cars cars() {
                return this.cars;
        }

        public boolean isOngoing() {
                return --round != -1;
        }

        public void moveOneRound() {
                cars.values().forEach(Car::moveForwardIfCan);
        }

        private Cars joinCars(String[] carNames) {
                return new Cars(Arrays.stream(carNames).map(carName -> new Car(carName, moveStrategy))
                    .collect(Collectors.toList()));
        }
}
