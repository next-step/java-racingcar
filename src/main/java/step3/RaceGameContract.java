package step3;

import step3.model.GameRound;
import step3.model.RacingCars;

public interface RaceGameContract {

    interface View {
        void renderView(RacingCars cars);
    }

    interface Presenter {
        void gameStart(GameRound round);
    }
}
