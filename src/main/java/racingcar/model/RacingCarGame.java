package racingcar.model;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {

        private static final Random random = new Random();
        private static final int RANDOM_BOUND = 10;
        private final String[] carNames;
        private final Cars cars;
        private int round;

        public RacingCarGame(int round, String[] carNames) {
                this.round = round;
                this.carNames = carNames;
                this.cars = joinCars();
        }

        public boolean isOngoing() {
                return --round != -1;
        }

        public void moveOneRound() {
                cars.moveOneRound(randomNumber());
        }

        private int randomNumber() {
                return random.nextInt(RANDOM_BOUND);
        }

        private Cars joinCars() {
                return new Cars(Arrays.stream(carNames).map(Car::new).collect(Collectors.toList()));
        }

        public Cars cars() {
                return this.cars;
        }

}
