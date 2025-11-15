package racingGame.business;

import java.util.List;

import racingGame.model.NonNegativeMoves;
import racingGame.model.NonNegativeReadyCars;
import racingGame.response.GameResponse;
import racingGame.model.Car;
import racingGame.model.GameResult;

public class Process {
    
    public GameResponse run(String[] names, int moves) {
        List<Car> joinCars = CarFactory.createCars(new NonNegativeReadyCars(names));
        GameResult gameResult = new GameMove(new NonNegativeMoves(moves)).moveCar(joinCars);
        List<Car> winners = gameResult.findWinners();
        return new GameResponse(gameResult, winners);
    }
}