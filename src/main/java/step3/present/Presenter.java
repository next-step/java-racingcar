package step3.present;

import step3.RaceGameContract;
import step3.model.Commander;
import step3.model.GameRound;
import step3.model.RaceGame;

public class Presenter implements RaceGameContract.Presenter {

    private final RaceGameContract.View view;
    private final Commander commander;

    public Presenter(RaceGameContract.View view, Commander commander) {
        this.view = view;
        this.commander = commander;
    }

    @Override
    public RaceGame createGame(GameRound round) {
        RaceGame raceGame = new RaceGame(round, commander);
        return raceGame;
    }

    @Override
    public void gameStart(RaceGame game) {
        game.start();
        view.renderView(game.end());
    }


}
