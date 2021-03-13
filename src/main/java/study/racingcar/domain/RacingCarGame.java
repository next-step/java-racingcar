package study.racingcar.domain;

import study.racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final List<RacingCar> racingCars;

    private final int numberOfAttempts;

    private int currentNumber;

    public RacingCarGame(String[] racingCarNames, int numberOfAttempts) {
        this.racingCars = racingCarsInit(racingCarNames);
        this.numberOfAttempts = numberOfAttempts;
        this.currentNumber = 0;
    }

    public RacingCarGame(List<RacingCar> racingCars, int numberOfAttempts) {
        this.racingCars = racingCars;
        this.numberOfAttempts = numberOfAttempts;
        this.currentNumber = 0;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> racingCarsInit(String[] carNames) {

        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new RacingCar(0, carName));
        }

        return racingCars;
    }

    public boolean racingAttemptsCheck() {

        if (currentNumber >= numberOfAttempts) {
            return false;
        }

        currentNumber ++;
        return true;
    }

    public void racing(){

        RandomGenerator randomGenerator = new RandomGenerator();

        for (RacingCar racingCar : racingCars) {
            racingCar.oneStep(randomGenerator.getRandomNumber());
        }

    }

    public String getRacingPrintInfo(){
        return String.join(", ", getWinnerNames(racingCars));
    }

    public List<String> getWinnerNames(List<RacingCar> racingCars) {

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
