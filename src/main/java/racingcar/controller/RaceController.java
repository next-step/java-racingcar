package racingcar.controller;

import racingcar.RandomMovableStrategy;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.service.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;

public final class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() throws IOException {
        final String names = inputView.inputNames();
        final String totalRound = inputView.inputTotalRound();
        race = Race.create(new RaceRequest(names, totalRound), new RandomMovableStrategy());
    }

    public void run() {
        outputView.printStartMessage();
        doRace();
    }

    public void finish() {
        outputView.printWinners(race.findWinners());
    }

    private void doRace() {
        while (race.getLeftRound().getValue() > 0) {
            race.play();
            outputView.printRound(new RaceResponse(race.getCars()));
        }
    }
}
