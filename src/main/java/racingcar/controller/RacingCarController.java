package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.racing.RacingGame;
import racingcar.domain.car.Cars;
import racingcar.dto.input.RacingCarRequest;
import racingcar.dto.output.RacingGameResponse;
import racingcar.util.ResponseEntity;

import java.util.List;

public class RacingCarController {

    private final RacingGame racingGame = new RacingGame();
    private final CarFactory carFactory = new CarFactory();

    public RacingGameResponse getRacingCarResult(RacingCarRequest parameter) {
        Cars cars = carFactory.createCars(parameter.getCarNames());
        List<Cars> racingGameResult = racingGame.startRacingGame(cars, parameter.getRacingCount());
        List<String> winners = racingGameResult.get(racingGameResult.size()-1).filterWinners();

        return ResponseEntity.ok(racingGameResult, winners);
    }

}
