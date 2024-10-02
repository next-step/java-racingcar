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

    public JavaRacingCar(String text, final int tryCount) throws RuntimeException {
        initCars(toList(split(text)));

        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void initCars(List<String> names) {
        for (String name : names) {
            validateName(name);
            cars.add(new RacingCar(name));
        }
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자 이상 입력");
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("음수 입력");
        }
    }

    private List<String> toList(String[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    private String[] split(String text) {
        return text.split(SPLIT_DELIMITER);
    }

    public List<RacingCar> cars() {
        return this.cars;
    }

    public int tryCount() {
        return this.tryCount;
    }
}
