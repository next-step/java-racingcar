package domain.game;

import java.util.List;

import domain.cars.MovingStrategy;
import domain.cars.RacingCar;
import domain.cars.RacingCars;
import domain.cars.RandomMovingStrategy;
import domain.request.RacingCarNameRequest;
import domain.request.RacingRoundRequest;
import domain.response.GameResultResponse;

public class Race {

    private RacingCars racingCars;
    private Winners winners;
    private RacingResult racingResult;

    public Race(RacingCarNameRequest request) {
        this.racingCars = new RacingCars(request);
    }

    public Race(List<RacingCar> racingCars) {
        this.racingCars = new RacingCars(racingCars);
    }

    public GameResultResponse race(RacingRoundRequest roundRequest) {
        MovingStrategy movingStrategy = new RandomMovingStrategy();
        racingResult = new RacingResult(roundRequest.getNumberOfRounds(), racingCars, movingStrategy);
        return new GameResultResponse(racingResult);
    }

    public List<String> getWinnerList() {
        winners = new Winners(racingCars);
        return winners.getWinners();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }
}
