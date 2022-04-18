package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.module.ResultView;

public class Race {
    private int carCount;
    private int raceCount;
    private List<RacingCar> racingCars;
    private Condition condition;

    public Race(int carCount, int raceCount, Condition condition) {
        this.carCount = carCount;
        this.raceCount = raceCount;
        this.condition = condition;

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
        racingCars.forEach(
            racingCar -> {
                int position = racingCar.moveOrStop();
                ResultView.printPosition(position);
            }
        );
    }

    private void makeRacingCars(int carCount) {
        racingCars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar(condition));
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
