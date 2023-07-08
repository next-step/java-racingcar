package racingcar.service;

import racingcar.MovableStrategy;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.dto.RaceRequest;
import racingcar.domain.Car;

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

    private static Cars createCars(RaceRequest raceRequest) {
        Cars cars = Cars.create();
        for (final String carName : raceRequest.getNames()) {
            cars.add(Car.create(carName));
        }
        return cars;
    }

    public Cars getCars() {
        return this.cars;
    }

    public int getLeftRound() {
        return this.leftRound.getValue();
    }

    public void play() {
        startRound();
        cars.move(movableStrategy);
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
