package racingcar.service;

import racingcar.MovableStrategy;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.dto.RaceRequest;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

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
        return this.leftRound.getRound();
    }

    public void play() {
        startRound();
        for (final Car car : cars.getCars()) {
            doPlay(car);
        }
    }

    private void doPlay(final Car car) {
        if (movableStrategy.isMove()) {
            car.moveForward();
        }
    }

    public String[] findWinners() {
        int maxPosition = 0;
        for (final Car car : cars.getCars()) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        final List<String> names = new ArrayList<>();
        for (final Car car : cars.getCars()) {
            if (maxPosition == car.getPosition()) {
                names.add(car.getName());
            }
        }

        return names.toArray(String[]::new);
    }

    private void startRound() {
        this.leftRound.decrease();
    }
}
