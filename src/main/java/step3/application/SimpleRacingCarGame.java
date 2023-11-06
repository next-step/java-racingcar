package step3.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.domain.Car;

public class SimpleRacingCarGame {

        private static final String RESET = "";
        private static final Random random = new Random();
        private final int carCnt;
        private final int round;
        private List<Car> cars = new ArrayList<>();
        private ArrayList<String> recordByRounds = new ArrayList<>();
        private String thisRoundRecord = RESET;

        public SimpleRacingCarGame(int carCnt, int round) {
                this.carCnt = carCnt;
                this.round = round;
        }

        public List<String> start() {
                joinCars();
                race();
                return recordByRounds;
        }

        public List<Car> joinCars() {
                return IntStream.range(0, carCnt).mapToObj(id -> new Car(String.valueOf(id)))
                    .collect(Collectors.toList());
        }

        private void race() {
                IntStream.range(0, round).forEach(thisRound -> {
                        moveOneRound();
                        recordPathsForAllCarsInThisRound();
                        resetThisRoundRecord();
                });
        }

        private void moveOneRound() {
                cars.forEach(car -> {
                        moveForwardIfCan(car);
                        recordPathForCarInThisRound(car);
                });
        }

        private void moveForwardIfCan(Car car) {
                if (isAbleToMove()) {
                        car.moveForward();
                }
        }

        private boolean isAbleToMove() {
                return random.nextInt(10) >= 4;
        }

        private void recordPathForCarInThisRound(Car car) {
                thisRoundRecord = thisRoundRecord.concat(car.getPath() + '\n');
        }

        private void recordPathsForAllCarsInThisRound() {
                recordByRounds.add(thisRoundRecord);
        }

        private void resetThisRoundRecord() {
                thisRoundRecord = RESET;
        }
}