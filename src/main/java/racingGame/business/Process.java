package racingGame.business;

import java.util.List;

import racingGame.response.GameResponse;
import racingGame.model.Car;
import racingGame.model.GameResult;

public class Process {
    
    public GameResponse run(String[] names, int moves) {
        List<Car> joinCars = CarFactory.createCars(names);
        GameResult gameResult = new GameMove(moves).moveCar(joinCars);
        List<Car> winners = gameResult.findWinners();
        return new GameResponse(gameResult, winners);
    }
}