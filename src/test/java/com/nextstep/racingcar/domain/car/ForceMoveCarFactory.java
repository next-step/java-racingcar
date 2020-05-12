package com.nextstep.racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ForceMoveCarFactory implements CarFactory {
    @Override
    public List<Car> createByNumber(int number) {
        List<Car> randomMoveCars = new ArrayList<>();
        IntStream.range(0, number).forEach(num -> randomMoveCars.add(new ForceMoveCar()));
        return new ArrayList<>(randomMoveCars);
    }
}
