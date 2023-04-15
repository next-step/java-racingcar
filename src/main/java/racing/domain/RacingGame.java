package racing.domain;

import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final List<RacingCar> gameCars;

    public RacingGame(List<RacingCar> gameCars) {
        this.gameCars = gameCars;
    }

    public List<RacingCar> getGameCars() {
        return Collections.unmodifiableList(gameCars);
    }


    public void progressCycle() {
        for (RacingCar gameCar : gameCars) {
            gameCar.move();
        }
    }

    public Winners findWinner() {
        return new Winners(gameCars);
    }
}
