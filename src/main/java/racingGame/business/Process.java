package racingGame.business;

import racingGame.model.*;
import racingGame.response.GameResponse;

public class Process {
    
    public GameResponse run(String[] names, int moves) {
        JoinCars joinCars = CarFactory.createCars(new NonNegativeReadyCars(names));
        GameResult gameResult = new GameMove(new NonNegativeMoves(moves)).moveCar(joinCars);
        JoinCars gameWinners = gameResult.findGameWinners();
        return new GameResponse(gameResult, gameWinners);
    }
}