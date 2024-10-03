package javaracingcarwinner.controller;

import javaracingcarwinner.dto.RacingInfoDto;
import javaracingcarwinner.entity.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaRacingCar {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private final List<RacingCar> cars = new ArrayList<>();

    private int tryCount;

    public JavaRacingCar(RacingInfoDto info) {
        initCars(toList(split(info.text())));
        validateTryCount(info.tryCount());
        this.tryCount = tryCount();
    }

    private String[] split(String text) {
        return text.split(SPLIT_DELIMITER);
    }

    private List<String> toList(String[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    private void initCars(List<String> names) {
        for (String name : names) {
            validateName(name);
            cars.add(new RacingCar(name));
        }
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자 초과");
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("음수 입력");
        }
    }

    public List<RacingCar> cars() {
        return this.cars;
    }

    public int tryCount() {
        return this.tryCount;
    }
}
