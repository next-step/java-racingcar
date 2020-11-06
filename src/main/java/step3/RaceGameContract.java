package step3;

import step3.model.RaceGame;

public interface RaceGameContract {

    interface View {
        void renderView(RaceGame raceGame);
    }

    interface Presenter {
        void gameStart();
    }
}
