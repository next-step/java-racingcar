package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {

        private static final Random random = new Random();
        private static final int RANDOM_BOUND = 10;
        private final String[] carNames;
        private final List<Car> cars;
        private int round;

        public RacingCarGame(int round, String[] carNames) {
                this.round = round;
                this.carNames = carNames;
                this.cars = joinCars();
        }

        public boolean isOngoing(){
                return --round != -1;
        }

        public void moveOneRound() {
                cars.forEach(car ->{
                        car.movedForwardIfCan(randomNo());
                });
        }

        private int randomNo(){
                return random.nextInt(RANDOM_BOUND);
        }

        private List<Car> joinCars() {
                return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
        }

        public List<Car> cars(){
                return this.cars;
        }

}
