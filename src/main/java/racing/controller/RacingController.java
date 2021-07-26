package racing.controller;

import racing.domain.car.entity.BasicCar;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.car.vo.fuel.RandomFuel;
import racing.domain.game.dto.GameRequest;
import racing.domain.game.RacingGame;
import racing.domain.game.dto.Turns;

public class RacingController {
    public Turns gameRun(GameRequest gameRequest) {
        Fuel fuel = new RandomFuel();
        RacingGame game = gameRequest.asGame(BasicCar::new);
        return game.racingAll(fuel);
    }
}
