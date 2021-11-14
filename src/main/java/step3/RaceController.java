package step3;

import java.util.List;

public class RaceController {
    private Race race;
    private GameBoard gameBoard;

    public RaceController() {
        setupRace();
    }

    private void setupRace() {
        race = new Race();
        gameBoard = new GameBoard();

        Count carCount = gameBoard.registerCar();
        Count trialCount = gameBoard.registerTrialCount();

        race.ready(carCount, trialCount);
    }

    public void gameStart() {
        List<Record> records = race.start();

        gameBoard.renderRaceResult(records);
    }
}
