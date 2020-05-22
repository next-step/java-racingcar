package com.cheolhyeonpark.step4.domain;

import java.util.List;

public class RacingGame {

    private final Stage stage;
    private int stageLeft;

    public RacingGame(String namesOfCars, int stageLeft) {
        validate(stageLeft);
        this.stage = new Stage(new Dice(), new CarMaker().getCars(namesOfCars));
        this.stageLeft = stageLeft;
    }

    private void validate(int stageLeft) {
        if (isNegativeInput(stageLeft)) {
            throw new IllegalArgumentException("Only positive input is allowed. Please check your input data.");
        }
    }

    private boolean isNegativeInput(int number) {
        return number < 0;
    }

    public void playStage() {
        stage.run();
        this.stageLeft--;
    }

    public List<Car> getResultOfStage() {
        return stage.getStageResult();
    }

    public boolean hasNextStage() {
        return stageLeft > 0;
    }

    public List<Car> getWinners() {
        return stage.getWinners();
    }
}
