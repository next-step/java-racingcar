package racingcar;

import java.util.ArrayList;
import racingcar.view.ResultView;

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
        ResultView.printResultMessage();
        for (int i = 0; i < raceCount; i++) {
            oneRound();
            ResultView.printNextRound();
        }
    }

    private void oneRound() {
        for (RacingCar racingCar : racingCars) {
            int position = racingCar.moveOrStop();
            ResultView.printPosition(position);
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
