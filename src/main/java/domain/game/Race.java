package domain.game;

import java.util.List;

import domain.cars.MovingStrategy;
import domain.cars.RacingCar;
import domain.cars.RacingCars;
import domain.cars.RandomMovingStrategy;
import domain.request.RacingCarNameRequest;
import domain.request.RacingRoundRequest;

public class Race {

    private RacingCars racingCars;
    private Winners winners;

    private RacingResult racingResult;

    public Race(RacingCarNameRequest request) {
        this.racingCars = RacingCars.of(request);
    }

    public Race(List<RacingCar> racingCars) {
        this.racingCars = new RacingCars(racingCars);
    }

    public RacingResult race(RacingRoundRequest roundRequest) {
        MovingStrategy movingStrategy = new RandomMovingStrategy();
        this.racingResult = new RacingResult();
        for (int i = 0; i < roundRequest.getNumberOfRounds(); i++) {
            racingCars.race(movingStrategy);
            racingResult.addEachRoundResult(racingCars.getResultOfEachCar());
        }
        determineWinners();
        return racingResult;
    }

    public void determineWinners() {
        this.winners = new Winners();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            findWinners(racingCar);
        }
    }

    private void findWinners(RacingCar racingCar) {
        int maxDistance = racingCars.getMaxDistance();
        if (racingCar.isSameDistance(maxDistance)) {
            winners.add(racingCar.getName());
        }
    }

    public List<String> getWinners() {
        return winners.getWinners();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }
}
