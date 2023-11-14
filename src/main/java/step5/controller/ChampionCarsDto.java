package step5.controller;

import step5.model.Car;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChampionCarsDto {
    private final List<Car> cars;

    public ChampionCarsDto(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        List<String> carNames = cars.stream().map(Car::getName).collect(Collectors.toList());
        return String.join(", ", carNames) + "가 최종 우승했습니다.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChampionCarsDto that = (ChampionCarsDto) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
