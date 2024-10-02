package javaracingcarwinner.controller;

import javaracingcarwinner.entity.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaRacingCar {
    private static final String SPLIT_DELIMITER = ",";
    private final List<RacingCar> cars = new ArrayList<>();

    public JavaRacingCar(String text) throws RuntimeException {
        List<String> names = split(text);

        for (String name : names) {
            validateName(name);
            cars.add(new RacingCar(name));
        }

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
}
