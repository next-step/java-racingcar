package study.racing;

import study.racing.view.RacingInput;

import java.util.*;

public class CarRacing {

    private final List<Integer> carRecords;
    private final Random random = new Random();
    private final int lastRound;

    private int currentRound = 0;

    public CarRacing(RacingInput racingInput) {
        this.carRecords = initRacingRecords(racingInput.getCountOfCar());
        this.lastRound = racingInput.getCountOfRound();
    }

    private List<Integer> initRacingRecords(int countOfCars) {
        return new ArrayList<>(Collections.nCopies(countOfCars, 0));
    }

    public boolean isEndRacing() {
        return (currentRound >= lastRound);
    }

    public void processRound() {
        for (int i = 0; i < carRecords.size(); i++) {
            if (getRandomNumber() >= 4) {
                carRecords.set(i, carRecords.get(i) + 1);
            }
        }
        currentRound++;
    }

    public List<Integer> getRoundRecords() {
        return carRecords;
    }

    private int getRandomNumber() {
        return random.nextInt(10);
    }

}
