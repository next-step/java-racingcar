package racingcar.domain;

import racingcar.domain.model.Position;
import racingcar.domain.model.RacingCar;
import racingcar.domain.model.RacingCars;
import racingcar.domain.model.Winners;
import racingcar.domain.moving.MovingStrategy;
import racingcar.dto.GameRequest;
import racingcar.dto.GameResult;

import java.util.stream.Collectors;

public class RacingGame {

    private final MovingStrategy movingStrategy;

    private RacingCars racingCars;
    private Integer numberOfTimes;

    public RacingGame(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public GameResult start(GameRequest gameRequest) {
        initialize(gameRequest);
        return race();
    }

    private void initialize(GameRequest gameRequest) {
        this.racingCars = RacingCars.of(gameRequest.getCarNames().stream()
                .map(name -> RacingCar.of(name, Position.of(0)))
                .collect(Collectors.toList()));
        this.numberOfTimes = gameRequest.getNumberOfTimes();
    }

    private GameResult race() {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < numberOfTimes; i++) {
            racingCars = move(racingCars);
            gameResult.addSnapshot(racingCars);
        }
        return gameResult;
    }

    private RacingCars move(RacingCars racingCars) {
        return RacingCars.of(racingCars.findAll().stream()
                .map(racingCar -> racingCar.move(movingStrategy))
                .collect(Collectors.toList()));
    }
}
