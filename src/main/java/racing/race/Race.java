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
    }

    private void init() {
        int participantsCount = inputView.promptParticipantsCount();
        int laps = inputView.promptLaps();
        this.game = new Game(participantsCount, laps);
        displayView.displayEmptyLine();
    }

    private void run() {
        displayView.displayRaceStart();

        IntStream.range(0, game.getLaps()).forEach(i -> {
            this.currentGameDisplay();
            game.runLap();
        });
    }

    private void currentGameDisplay() {
        displayView.displayCarsPosition(game.getParticipants());
        displayView.displayEmptyLine();
    }
}
