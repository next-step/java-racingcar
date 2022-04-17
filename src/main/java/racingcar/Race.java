package racingcar;

import java.util.ArrayList;

public class Race {
    private int carCount;
    private int raceCount;
    private ArrayList<RacingCar> racingCars;

    Race(int carCount, int raceCount) {
        this.carCount = carCount;
        this.raceCount = raceCount;

        makeRacingCars(carCount);
    }

    public void startRace() {
        for (int i = 0; i < raceCount; i++) {
            oneRound();
        }
    }

    private void oneRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop();
        }
    }

    private void makeRacingCars(int carCount) {
        racingCars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
