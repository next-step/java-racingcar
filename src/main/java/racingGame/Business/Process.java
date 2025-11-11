package racingGame.Business;

import java.util.List;

import racingGame.Response.GameFinalResult;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;

public class Process {
    
    public GameFinalResult run(String[] names, int moves) {
        List<Car> joinCars = new CarFactory().createCars(names);
        GameFinalResult gameFinalResult = new GameMove(moves).moveCar(joinCars);
        return gameFinalResult;
    }

}