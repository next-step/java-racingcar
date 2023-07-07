package racingcar.service;

import racingcar.NumberGenerator;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.dto.RaceRequest;
import racingcar.util.RaceUtil;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public final class Race {

    private final Cars cars;
    private final Round leftRound;

    private Race(final Cars cars, final int leftRound) {
        this.cars = cars;
        this.leftRound = Round.from(leftRound);
    }

    public static Race of(final String[] carNames, final int count) {
        Cars cars = Cars.create();
        for (final String carName : carNames) {
            cars.add(Car.create(carName));
        }

        return new Race(cars, count);
    }

    public static Race from(final RaceRequest raceRequest) {
        return of(raceRequest.getNames(), raceRequest.getTotalRound());
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }

    public int getLeftRound() {
        return this.leftRound.getRound();
    }

    public void play(final NumberGenerator numberGenerator) {
        startRound();
        for (final Car car : cars.getCars()) {
            doPlay(numberGenerator, car);
        }
    }

    private void doPlay(final NumberGenerator numberGenerator, final Car car) {
        if (RaceUtil.determineCarMovement(numberGenerator.generate())) {
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
