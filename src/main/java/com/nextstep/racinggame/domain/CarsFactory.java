package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidNamesException;

import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {
    private static final int MIN_SIZE = 0;

    public static Cars createCars(final List<Name> names) {
        validate(names);

        List<Car> requestedCars = names.stream()
                .map(name -> new Car(0, name))
                .collect(Collectors.toList());

        return new Cars(requestedCars);
    }

    private static void validate(final List<Name> names) {
        if (names == null) {
            throw new InvalidNamesException("null로 객체를 생성할 수 없습니다.");
        }
        if (names.size() == MIN_SIZE) {
            throw new InvalidNamesException("한 개 이상의 차량 이름이 있어야 합니다.");
        }
    }
}
