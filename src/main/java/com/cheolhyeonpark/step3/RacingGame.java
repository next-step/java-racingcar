package com.cheolhyeonpark.step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    public static final String GAME_RESULT = "실행결과";

    private final Stage stage;
    private final int numberOfStages;

    public RacingGame(int numberOfCars, int numberOfStages) {
        this.stage = new Stage(new Dice(), getCars(numberOfCars));
        this.numberOfStages = numberOfStages;
    }

    private List<Car> getCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars).mapToObj(i -> new Car()).collect(Collectors.toList());
    }

    public void play() {
        System.out.println(GAME_RESULT);
        IntStream.range(0, numberOfStages).forEach(i -> runStage());
    }

    private void runStage() {
        stage.run();
        stage.printResult();
        System.out.println();
    }
}
