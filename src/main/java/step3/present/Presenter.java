package step3.present;

import step3.RaceGameContract;
import step3.model.Commander;
import step3.model.RaceGame;
import step3.model.RacingCars;
import step3.model.GameRound;

public class Presenter implements RaceGameContract.Presenter {

    private final RaceGameContract.View view;
    private final Commander commander;

    public Presenter(RaceGameContract.View view, Commander commander) {
        this.view = view;
        this.commander = commander;
    }

    @Override
    public void gameStart(GameRound round) {
        RaceGame raceGame = new RaceGame(round, commander);

        while (!round.isAllRoundFinish()) {
            RacingCars cars = raceGame.nextRound();
            view.renderView(cars);
        }
    }
}
