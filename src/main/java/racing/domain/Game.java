package racing.domain;

import java.util.List;

public class Game {
    private final List<Car> gameCars;

    public Game(List<Car> gameCars) {
        this.gameCars = gameCars;
    }

    public GameStatus getStatus() {
        return new GameStatus(gameCars);
    }

    public void progressCycle() {
        for (Car gameCar : gameCars) {
            gameCar.move();
        }
    }

    private Winners findWinner() {
        return new Winners(gameCars);
    }

    public List<Name> getWinnerNames() {
        return findWinner().toNames();
    }
}