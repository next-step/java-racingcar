package racingcar;

import racingcar.model.RaceGame;

public interface RaceGameContract {

    interface View {
        void renderView(RaceGame raceGame);
    }

    interface Presenter {
        void gameStart();
    }
}
