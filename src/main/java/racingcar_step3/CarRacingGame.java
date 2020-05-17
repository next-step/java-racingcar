package racingcar_step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingGame {

    private Random rand = new Random();
    private List<Integer> carPositions = new ArrayList<>();

    private int racingCarCount;
    private int racingCount;

    CarRacingGame(int racingCarCount, int racingCount) {
        this.racingCarCount = racingCarCount;
        this.racingCount = racingCount;
    }

    public void initValue() {
        validateInput(racingCarCount, racingCount);
        setCarPositions();
    }

    private void validateInput(int racingCarCount, int racingCount) {
        if (racingCarCount <= 0 || racingCount <= 0) {
            throw new IllegalArgumentException("Input Value Error");
        }
    }

    private void setCarPositions() {
        for (int i=0; i < racingCarCount; i++) {
            carPositions.add(0);
        }
    }

    private int getRandom() {
        return rand.nextInt(CarRacingEnum.RANDOM_RANGE.getValue());
    }

    public void move() {
        for (int i=0; i < racingCount; i++) {
            for (int j=0; j < carPositions.size(); j++) {
                int carPosition = carPositions.get(j);
                carPosition += setForward(getRandom());
                carPositions.set(j, carPosition);
            }
        }
    }

    public int setForward(int randomNumber) {
        return randomNumber < CarRacingEnum.MOVE_POSSIBLE_VALUE.getValue() ?
                CarRacingEnum.STOP_VALUE.getValue() : CarRacingEnum.FORWARD_VALUE.getValue();
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
