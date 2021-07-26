package racing.controller;

import racing.domain.car.vo.fuel.Fuel;
import racing.domain.car.vo.fuel.RandomFuel;
import racing.domain.game.dto.GameRequest;
import racing.domain.game.RacingGame;
import racing.domain.game.vo.Turns;

public class RacingController {
    public Turns gameRun(GameRequest gameRequest) {
        Fuel fuel = new RandomFuel();
        RacingGame game = new RacingGame(gameRequest.cars(), gameRequest.turns());
        return game.racingAll(fuel);
    }
}
