package com.nextstep.camp.racing.domain.vo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.exception.CarNotFoundException;

public class Cars {

    private final List<Car> values;

    private Cars(PositiveInteger carQuantity) {
        this.values = Stream.generate(Car::of)
            .limit(carQuantity.value())
            .collect(Collectors.toList());
    }

    public static Cars of(PositiveInteger carQuantity) {
        return new Cars(carQuantity);
    }

    public void move() {
        values.forEach(Car::move);
    }

    public PositiveInteger getMaxPosition() {
        return values.stream()
            .map(Car::getPosition)
            .max(PositiveInteger::compareTo)
            .orElseThrow(CarNotFoundException::new);
    }

    public int size() {
        return values.size();
    }

    public Cars copy() {
        return new Cars(PositiveInteger.of(values.size()));
    }

    public Stream<Car> stream() {
        return values.stream();
    }
}
