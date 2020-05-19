package racingcar_step3;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<Integer> carPositions = new ArrayList<>();

    private int racingCarCount;
    private int racingCount;

    Car(int racingCarCount, int racingCount) {
        this.racingCarCount = racingCarCount;
        this.racingCount = racingCount;
        initValue();
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

    public int setForward(int randomNumber) {
        return randomNumber < CarRacingEnum.MOVE_POSSIBLE_VALUE.getValue() ?
                CarRacingEnum.STOP_VALUE.getValue() : CarRacingEnum.FORWARD_VALUE.getValue();
    }

    public int getRacingCarCount() {
        return this.racingCarCount;
    }

    public int getRacingCount() {
        return this.racingCount;
    }

    public List<Integer> getCarPositions(){
        return this.carPositions;
    }
}
