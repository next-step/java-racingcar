package com.cheolhyeonpark.step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final Stage stage;
    private int stageLeft;

    public RacingGame(int numberOfCars, int stageLeft) {
        this.stage = new Stage(new Dice(), getCars(numberOfCars));
        this.stageLeft = stageLeft;
    }

    private List<Car> getCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars).mapToObj(i -> new Car()).collect(Collectors.toList());
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
