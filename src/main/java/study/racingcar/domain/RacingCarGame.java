package study.racingcar.domain;

import study.racingcar.util.RandomGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final List<RacingCar> racingCars;
    private final int numberOfAttempts;
    private int currentNumber;

    private RacingCarGame(Builder builder) {
        racingCars = builder.racingCars;
        numberOfAttempts = builder.numberOfAttempts;
        currentNumber = builder.currentNumber;
    }

    public static class Builder {
        private final int numberOfAttempts;
        private List<RacingCar> racingCars;
        private int currentNumber = 0;

        public Builder(int numberOfAttempts) {
            this.numberOfAttempts = numberOfAttempts;
        }

        public Builder racingCars(List<RacingCar> racingCars) {
            this.racingCars = racingCars;
            return this;
        }

        public Builder racingCars(String[] racingCarNames) {
            this.racingCars = racingCarsInit(racingCarNames);
            return this;
        }

        public Builder racingCars(String nameOfCars) {
            this.racingCars = racingCarsInit(getSplitCarNames(nameOfCars));
            return this;
        }

        public Builder currentNumber(int currentNumber) {
            this.currentNumber = currentNumber;
            return this;
        }

        public RacingCarGame build() {
            return new RacingCarGame(this);
        }
    }


    public static String[] getSplitCarNames(String nameOfCars) {
        return nameOfCars.split(",");
    }

    private static List<RacingCar> racingCarsInit(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> new RacingCar(0, carName))
                .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public boolean racingAttemptsCheck() {

        if (currentNumber >= numberOfAttempts) {
            return false;
        }

        currentNumber++;
        return true;
    }

    public void racing() {
        for (RacingCar racingCar : racingCars) {
            racingCar.oneStep(randomGenerator.getRandomNumber());
        }
    }

    public String getRacingPrintInfo() {
        return String.join(", ", getWinnerNames(racingCars));
    }

    private List<String> getWinnerNames(List<RacingCar> racingCars) {

        int maxPosition = getMaxPosition(racingCars);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getPosition))
                .get().getPosition();
    }
}
