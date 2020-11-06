package step3.present;

import step3.RaceGameContract;
import step3.model.RaceGame;

public class Presenter implements RaceGameContract.Presenter {

    private final RaceGameContract.View view;
    private final RaceGame raceGame;

    public Presenter(RaceGameContract.View view, RaceGame raceGame) {
        this.view = view;
        this.raceGame = raceGame;
    }

    @Override
    public void gameStart() {
        raceGame.start();
        view.renderView(raceGame);
    }


}
