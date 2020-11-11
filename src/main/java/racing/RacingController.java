package racing;

import racing.domain.RaceRound;
import racing.service.GameManager;

public class RacingController {

    private final GameManager gameManager;

    public RacingController(String names,int laps) {
        this.gameManager = new GameManager(names,laps);
    }

    public void execute() {
        gameManager.start();
    }

    public RaceRound getRacingRound() {
        return gameManager.getRaceRound();
    }
}
