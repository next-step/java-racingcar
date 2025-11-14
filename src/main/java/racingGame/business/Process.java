package racingGame.business;

import java.util.List;

import racingGame.response.GameFinalResult;
import racingGame.model.Car;

public class Process {
    
    public GameFinalResult run(String[] names, int moves) {
        List<Car> joinCars = new CarFactory().createCars(names);
        GameFinalResult gameFinalResult = new GameMove(moves).moveCar(joinCars);
        return gameFinalResult;
    }

}