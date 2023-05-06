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
        setGame(names, laps);
        displayView.displayEmptyLine();
    }

    private void run() {
        displayView.displayRaceStart();
        this.currentGameDisplay();

        IntStream.range(0, game.getLaps()).forEach(i -> {
            game.runLap();
            this.currentGameDisplay();
        });
    }

    private void setGame(String names, int laps) {
        this.game = Game.builder()
                .setCarNames(names)
                .setLaps(laps)
                .build();
    }

    private void showResult() {
        displayView.displayWinners(game.getWinners());
    }

    private void currentGameDisplay() {
        displayView.displayCarsPosition(game.getParticipants());
        displayView.displayEmptyLine();
    }
}
