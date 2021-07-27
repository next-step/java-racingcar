package racing.controller;

import racing.domain.car.Cars;
import racing.domain.dto.GameResponse;
import racing.domain.fuel.Fuel;
import racing.domain.fuel.RandomFuel;
import racing.domain.dto.GameRequest;
import racing.service.RacingGame;
import racing.exception.InvalidInputException;

import java.util.List;


public final class RacingController {
    private RacingController() {}

    public static RacingController getInstance() {
        return InnerClazz.racingGame;
    }

    public GameResponse gameRun(GameRequest gameRequest) {
        if (!gameRequest.hasTurn()) {
            throw new InvalidInputException("진행할 턴이 없습니다.");
        }
        Fuel fuel = new RandomFuel();
        List<Cars> gameResults = RacingGame.getInstance().racingAll(
                gameRequest.cars(), gameRequest.turnSize(), fuel
        );

        return new GameResponse(gameResults);
    }

    private static class InnerClazz {
        private static RacingController racingGame = new RacingController();
    }
}
