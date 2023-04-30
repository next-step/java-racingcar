package racing.race;

import racing.ui.InputView;
import racing.ui.DisplayView;

import java.util.stream.IntStream;

public class Race {
    private final InputView inputView;
    private final DisplayView displayView;
    private Game game;

    public Race(InputView inputView, DisplayView displayView) {
        this.inputView = inputView;
        this.displayView = displayView;
    }

    public void start() {
        this.init();
        this.run();
        this.showResult();
    }

    private void init() {
        String names = inputView.promptNames();
        int laps = inputView.promptLaps();
        this.game = new Game(names, laps);
        displayView.displayEmptyLine();
    }

    private void run() {
        displayView.displayRaceStart();

        IntStream.range(0, game.getLaps()).forEach(i -> {
            this.currentGameDisplay();
            game.runLap();
        });
    }

    private void showResult() {
        displayView.displayWinners(game.getWinners());
    }

    private void currentGameDisplay() {
        displayView.displayCarsPosition(game.getParticipants());
        displayView.displayEmptyLine();
    }
}
