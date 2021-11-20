package step3.domain;

import step3.domain.gameStrategy.CarGameStrategy;
import step3.view.dto.InputDto;

import java.util.List;


public class CarRacingGame {

    private final CarGameStrategy carGameStrategy;
    private final int totalRound;
    private CarCollection carCollection;

    private CarRacingGame(CarGameStrategy carGameStrategy, int totalRound) {
        this.carGameStrategy = carGameStrategy;
        this.totalRound = totalRound;
    }

    public static CarRacingGame of(InputDto inputDto, CarGameStrategy carGameStrategy) {
        CarRacingGame carRacingGame = new CarRacingGame(carGameStrategy, inputDto.getNumberOfAttempts());
        int numberOfCars = inputDto.getNumberOfCars();
        carRacingGame.carCollection = new CarCollection(numberOfCars);
        return carRacingGame;
    }

    public void play() {
        for (int round = 0; round < totalRound; round++) {
            carCollection.playOneRound(carGameStrategy);
        }
    }

    public int getTotalRound() {
        return totalRound;
    }

    public List<Integer> getCarsPosition(int round) {
        return carCollection.getPosition(round);
    }

}