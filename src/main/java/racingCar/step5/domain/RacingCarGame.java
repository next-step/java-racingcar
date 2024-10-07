package racingCar.step5.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final RacingCars cars;
    private final RandomNumber randomNumber;

    private List<RacingCars> gameResult;

    public RacingCarGame(RacingCars cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public List<RacingCars> start(int racingCont) {
        initialize(cars);
        raceRounds(cars, racingCont);

        return gameResult;
    }

    private void initialize(RacingCars cars) {
        gameResult = new ArrayList<>();
    }

    private void raceRounds(RacingCars cars, int racingCont) {
        for (int i = 0; i < racingCont; i++) {
            cars.move(randomNumber);
            gameResult.add(cars.copy());
        }
    }

    public List<RacingCar> decideWinner() {
        int maxPosition = cars.maxPosition();
        List<RacingCar> winners = cars.samePosition(maxPosition);
        return winners;
    }

}
