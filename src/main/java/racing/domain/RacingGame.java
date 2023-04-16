package racing.domain;

import java.util.ArrayList;
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

    private Winners findWinner() {
        return new Winners(gameCars);
    }

    public List<Name> getWinnerNames() {
        Winners winners = findWinner();
        List<Name> winnerNames = new ArrayList<>();
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.add(winners.get(i).name());
        }
        return winnerNames;
    }
}