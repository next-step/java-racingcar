package study.racing;

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

    public boolean isProcessAbleRound() {
        return (currentRound < lastRound);
    }

    public void processRound() {

        if(!isProcessAbleRound()) {
            throw new RuntimeException("더 이상 라운드를 진행 할 수 없습니다.");
        }

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
