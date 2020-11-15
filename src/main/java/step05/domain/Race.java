package step05.domain;

import step03.strategy.MoveStrategy;
import validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {
    private final int numberOfMoves;
    private final Cars cars;

    private Race(int numberOfMoves, Cars cars) {
        this.numberOfMoves = numberOfMoves;
        this.cars = cars;
        validateNumberOfMoves();
    }

    public static Race of(int numberOfMoves, Cars cars) {
        return new Race(numberOfMoves, cars);
    }

    private void validateNumberOfMoves() {
        NumberValidator.validatePositiveNumber(numberOfMoves);
    }

    public List<Cars> run(MoveStrategy moveStrategy) {
        List<Cars> raceSnapShot = new ArrayList<>();
        Cars tempCars = cars;
        raceSnapShot.add(tempCars);

        for(int i = 0; i < numberOfMoves; i++) {
            tempCars = tempCars.move(moveStrategy);
            raceSnapShot.add(tempCars);
        }

        return raceSnapShot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return numberOfMoves == race.numberOfMoves &&
                cars.equals(race.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfMoves, cars);
    }
}
