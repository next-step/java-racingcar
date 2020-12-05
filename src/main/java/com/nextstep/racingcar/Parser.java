package com.nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<CarName> parseCarNames(String line) {
        List<CarName> carNames = new ArrayList<>();
        String[] names = line.split(",");

        for (String name : names ) {
            name = name.trim();
            carNames.add(new CarName(name));
        }
        return carNames;
    }
}
