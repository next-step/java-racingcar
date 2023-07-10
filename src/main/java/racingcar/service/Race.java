package racingcar.service;

import racingcar.MovableStrategy;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.dto.RaceRequest;

import java.util.List;
import java.util.stream.Collectors;

public final class Race {

    private final Cars cars;
    private final Round leftRound;
    private final MovableStrategy movableStrategy;

    private Race(final Cars cars, final int leftRound, MovableStrategy movableStrategy) {
        this.cars = cars;
        this.leftRound = Round.from(leftRound);
        this.movableStrategy = movableStrategy;
    }

    public static Race create(final RaceRequest raceRequest, MovableStrategy movableStrategy) {
        Cars cars = createCars(raceRequest);
        return new Race(cars, raceRequest.getTotalRound(), movableStrategy);
    }

    private static Cars createCars(final RaceRequest raceRequest) {
        return Cars.of(raceRequest.getNames());
    }

    public Cars getCars() {
        return this.cars;
    }

    public Round getLeftRound() {
        return this.leftRound;
    }

    public void play() {
        startRound();
        cars.moveAll(movableStrategy);
    }

    public List<String> findWinners() {
        return cars.findMaxPositionCars()
                .stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    private void startRound() {
        this.leftRound.decrease();
    }
}
