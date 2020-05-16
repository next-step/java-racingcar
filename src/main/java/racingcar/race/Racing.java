package racingcar.race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private List<Car> carList = new ArrayList<>();
    private Dice dice;
    private int gameCount = 0;

    public Racing(Dice dice, int racingCount) {
        checkRacingCount(racingCount);

        this.gameCount = racingCount;
        this.dice = dice;
    }

    public void joinRace(int carCount) {
        for(int i = 0 ; i < carCount ; i++) {
            carList.add(new Car());
        }
    }

    public void start(GameResultReceiver receiver) {
        for(int i = 0 ; i < gameCount ; i++) {
            race();
            receiver.notifyFinishRace(getRaceResult());
        }
    }

    private void checkRacingCount(int racingCount) {
        if(racingCount <= 0) {
            throw new IllegalArgumentException("The number of racingCount must be at least 1.");
        }
    }

    private List<Integer> getRaceResult() {
        return carList.stream().map(Car::getPosition).collect(Collectors.toList());
    }

    private void race() {
        for(Car car : carList) {
            car.drive(getMoveForwardCount());
        }
    }

    private int getMoveForwardCount() {
        int forwardCount = 1;
        if( dice.generate() < 4) {
            forwardCount = 0;
        }
        return forwardCount;
    }
}
