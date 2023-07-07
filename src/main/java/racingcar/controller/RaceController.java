package racingcar.controller;

import racingcar.NumberGenerator;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.service.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;

public final class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private Race race;

    public RaceController(final NumberGenerator numberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = numberGenerator;
    }

    public void start() throws IOException {
        final String names = inputView.inputNames();
        final String totalRound = inputView.inputTotalRound();
        race = Race.from(new RaceRequest(names, totalRound));
    }

    public void run() {
        OutputView.printStartMessage();
        doRace();
    }

    public void finish() {
        outputView.printWinners(race.findWinners());
    }

    private void doRace() {
        final int leftRound = race.getLeftRound();
        for (int round = 0; round < leftRound; round++) {
            race.play(numberGenerator);
            outputView.printRound(new RaceResponse(race.getCars()));
        }
    }
}
