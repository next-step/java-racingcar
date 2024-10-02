package javaracingcarwinner.controller;

import javaracingcarwinner.entity.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaRacingCar {
    private static final String SPLIT_DELIMITER = ",";
    private final List<RacingCar> cars = new ArrayList<>();

    private final int tryCount;

    public JavaRacingCar(String text, int tryCount) throws RuntimeException {
        List<String> names = split(text);

        initCars(names);
        validateTryCount(tryCount);

        this.tryCount = tryCount;
    }

    private void initCars(List<String> names) {
        for (String name : names) {
            validateName(name);
            cars.add(new RacingCar(name));
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 0) throw new IllegalArgumentException("음수 입력");
    }

    private List<String> split(String text) {
        return Arrays.stream(text.split(SPLIT_DELIMITER)).collect(Collectors.toList());
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자 이상 입력");
        }
    }

    public List<RacingCar> cars() {
        return this.cars;
    }

    public int tryCount() {
        return this.tryCount;
    }
}
