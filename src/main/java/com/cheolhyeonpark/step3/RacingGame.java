package com.cheolhyeonpark.step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private Stage stage;

    private void generateStage(int numberOfCars) {
        this.stage = new Stage(new Dice(), getCars(numberOfCars));
    }

    private List<Car> getCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars).mapToObj(i -> new Car()).collect(Collectors.toList());
    }
}
