package step4.service;

import step4.service.dto.GameHistory;
import step4.service.dto.GameInformation;
import step4.strategy.MoveStrategy;
import step4.domain.Names;
import step4.domain.Cars;

public class Game {

    private final Integer time;
    private final Names names;
    private final MoveStrategy moveStrategy;
    private Cars cars;

    private Game(Names names, Integer time, MoveStrategy moveStrategy) {
        this.time = time;
        this.names = names;
        this.moveStrategy = moveStrategy;
    }

    public static Game of(GameInformation gameInformation, MoveStrategy moveStrategy) {
        return new Game(gameInformation.getNames(), gameInformation.getTime(), moveStrategy);
    }

    public GameHistory start() {
        GameHistory gameHistory = new GameHistory();
        makeCars();
        for (int now = 0; now < this.time; now++) {
            step();
            gameHistory.save(now, cars);
        }
        gameHistory.saveWinner(cars.getWinner());

        return gameHistory;
    }

    private void makeCars() {
        cars = Cars.createWithDefaultPosition(names);
    }

    private void step() {
        this.cars = this.cars.move(moveStrategy);
    }
}
