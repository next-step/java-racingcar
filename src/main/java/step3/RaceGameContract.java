package step3;

import step3.model.GameRound;
import step3.model.RaceGame;
import step3.model.RacingCars;

public interface RaceGameContract {

    interface View {
        void renderView(RacingCars racingCars);
    }

    interface Presenter {
        RaceGame createGame(GameRound gameRound);
        void gameStart(RaceGame raceGame);
    }
}
