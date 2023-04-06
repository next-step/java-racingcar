package step3.domain;

import java.util.List;

public class Repetitions {
    private int repetitions;
    private List<RacingCar> racingCarList;

    public static final Repetitions _INSTANCE = new Repetitions();

    public int getRepetitions() {
        return repetitions;
    }

    public List<RacingCar> getCarList() {
        return racingCarList;
    }

    public boolean isLastReps(int numberOfReps) {
        return repetitions == numberOfReps;
    }

    public Repetitions record(List<RacingCar> racingCarList) {
        increaseReps();
        this.racingCarList = racingCarList;

        return this;
    }

    private void increaseReps() {
        repetitions++;
    }
}

