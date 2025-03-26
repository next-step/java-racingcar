package com.nextstep.camp.racing.domain.vo;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.exception.CarNotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> values;

    private Cars(CarNames carNames) {
        this.values = carNames.stream()
            .map(Car::of)
            .collect(Collectors.toList());
    }

    private Cars(List<Car> values) {
        this.values = values;
    }

    public static Cars of(CarNames carNames) {
        return new Cars(carNames);
    }

    public static Cars of(List<Car> values) {
        return new Cars(values);
    }

    public void move() {
        values.forEach(Car::move);
    }

    public int size() {
        return values.size();
    }

    public Stream<Car> stream() {
        return values.stream();
    }

    public List<CarMoves> getCarsLapRecord() {
        return values.stream()
                .map(Cars::getCarLapRecord)
                .collect(Collectors.toList());
    }

    private static CarMoves getCarLapRecord(Car car) {
        Moves moves = Moves.of(car.getMoves().getValues());
        return CarMoves.of(car, moves);
    }

    public void recordWinners() {
        PositiveInteger maxPosition = getMaxPosition();
        values.stream()
            .filter(car -> car.getPosition().equals(maxPosition))
            .forEach(Car::win);
    }

    public Cars getWinners() {
        return values.stream()
            .filter(Car::isWinner)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::of));
    }

    private PositiveInteger getMaxPosition() {
        return values.stream()
            .map(Car::getPosition)
            .max(PositiveInteger::compareTo)
            .orElseThrow(CarNotFoundException::new);
    }
}
