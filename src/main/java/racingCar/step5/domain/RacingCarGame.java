package racingCar.step5.domain;

import racingCar.step5.domain.dto.RacingCarGameResult;

import java.util.List;

public class RacingCarGame {
    private final RacingCars cars;
    private final RandomNumber randomNumber;

    private RacingCarGameResult gameResult;

    public RacingCarGame(RacingCars cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public RacingCarGameResult start() {
        initialize(cars);
        startRace(cars);
        decideWinner(cars);

        return gameResult;
    }

    private void initialize(RacingCars cars) {
        gameResult = new RacingCarGameResult();
    }

    private void startRace(RacingCars cars) {
        cars.move(randomNumber);
        gameResult.addRacingResult(cars);
    }

    private void decideWinner(RacingCars cars) {
        int maxPosition = cars.maxPosition();
        List<RacingCar> winners = cars.samePosition(maxPosition);
        gameResult.addWinner(winners);
    }

}
