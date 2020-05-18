package me.daeho.step3;

import me.daeho.step3.rule.DefaultRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RacingGame {
    private int time;
    private int[] carPositions;
    private List<Car> cars;

    private RacingGame(int time, List<Car> cars, int[] carPositions) {
        this.time = time;
        this.carPositions = carPositions;
        this.cars = cars;
    }

    public static RacingGame init(int time, int carCount) {
        return new RacingGame(time, readyCars(carCount), new int[carCount]);
    }

    private static List<Car> readyCars(int carCount) {
        return new ArrayList<Car>(){{
            IntStream.range(0, carCount).forEach(v -> add(Car.ready(new DefaultRule())));
        }};
    }

    public int[] move() {
        for (int i = 0; i < cars.size(); i++) {
            carPositions[i] = cars.get(i).move();
        }
        return carPositions;
    }

    public void next() {
        time--;
    }

    public boolean hasNext() {
        return time > 0;
    }
}

