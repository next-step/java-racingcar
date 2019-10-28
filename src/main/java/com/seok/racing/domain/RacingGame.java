package com.seok.racing.domain;

import static com.seok.racing.utils.StringUtils.split;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private int times;
    private Cars cars;

    public RacingGame(String names, int times) {
        register(split(names));
        this.times = times;
    }

    private void register(String[] names) {
        List<Car> cars = Arrays.stream(names)
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList());
        this.cars = new Cars(cars);
    }

    public void start() {
        int trials = 0;
        while (trials++ < times) {
            cars.move();
        }
    }

    public int getTimes() {
        return times;
    }

    public Cars getCars() {
        return cars;
    }

}
