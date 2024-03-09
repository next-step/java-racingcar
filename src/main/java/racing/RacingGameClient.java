package racing;

import racing.domain.RacingGameManager;

public class RacingGameClient {
    public static void main(String[] args) {
        RacingGameManager racingGameManager = new RacingGameManager();
        racingGameManager.play();
    }
}
