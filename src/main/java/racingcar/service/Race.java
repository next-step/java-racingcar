package racingcar.service;

import racingcar.NumberGenerator;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.dto.RaceRequest;
import racingcar.util.RaceUtil;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final Cars cars;
    private final Round leftRound;

    private Race(Cars cars, int leftRound) {
        this.cars = cars;
        this.leftRound = Round.from(leftRound);
    }

    public static Race of(String[] carNames, int count) {
        Cars cars = Cars.create();
        for (String carName : carNames) {
            cars.add(Car.create(carName));
        }

        return new Race(cars, count);
    }

    public static Race from(RaceRequest raceRequest) {
        return of(raceRequest.getNames(), raceRequest.getTotalRound());
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }

    public int getLeftRound() {
        return this.leftRound.getRound();
    }

    public void play(NumberGenerator numberGenerator) {
        startRound();
        for (Car car : cars.getCars()) {
            doPlay(numberGenerator, car);
        }
    }

    private void doPlay(NumberGenerator numberGenerator, Car car) {
        if (RaceUtil.determineCarMovement(numberGenerator.generate())) {
            car.moveForward();
        }
    }

    public String[] findWinners() {
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        List<String> names = new ArrayList<>();
        for (Car car : cars.getCars()) {
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
