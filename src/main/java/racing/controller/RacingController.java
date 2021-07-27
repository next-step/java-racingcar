package racing.controller;

import racing.domain.fuel.Fuel;
import racing.domain.fuel.RandomFuel;
import racing.domain.dto.GameRequest;
import racing.domain.RacingGame;
import racing.domain.turn.Turns;

public class RacingController {
    public Turns gameRun(GameRequest gameRequest) {
        Fuel fuel = new RandomFuel();
        RacingGame game = new RacingGame(gameRequest.cars(), gameRequest.turns());
        return game.racingAll(fuel);
    }
}
