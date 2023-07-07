package racingcar.controller;

import racingcar.MovableStrategy;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.service.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;

public final class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MovableStrategy movableStrategy;
    private Race race;

    public RaceController(final MovableStrategy movableStrategy) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.movableStrategy = movableStrategy;
    }

    public void start() throws IOException {
        final String names = inputView.inputNames();
        final String totalRound = inputView.inputTotalRound();
        race = Race.from(new RaceRequest(names, totalRound));
    }

    public void run() {
        outputView.printStartMessage();
        doRace();
    }

    public void finish() {
        outputView.printWinners(race.findWinners());
    }

    private void doRace() {
        final int leftRound = race.getLeftRound();
        for (int round = 0; round < leftRound; round++) {
            race.play(movableStrategy);
            outputView.printRound(new RaceResponse(race.getCars()));
        }
    }
}
