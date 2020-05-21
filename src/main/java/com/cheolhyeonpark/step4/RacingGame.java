package com.cheolhyeonpark.step4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    public static final int CAR_START_POSITION = 0;

    private final Stage stage;
    private int stageLeft;

    public RacingGame(int numberOfCars, int stageLeft) {
        validate(numberOfCars, stageLeft);
        this.stage = new Stage(new Dice(), getCars(numberOfCars));
        this.stageLeft = stageLeft;
    }

    private void validate(int numberOfCars, int stageLeft) {
        if (isNegativeInput(numberOfCars, stageLeft)) {
            throw new IllegalArgumentException("Only positive input is allowed. Please check your input data.");
        }
    }

    private boolean isNegativeInput(int numberOfCars, int stageLeft) {
        return numberOfCars < 0 || stageLeft < 0;
    }

    private List<Car> getCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars).mapToObj(i -> new Car(CAR_START_POSITION)).collect(Collectors.toList());
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
}
