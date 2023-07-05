package racingcar.controller;

import racingcar.NumberGenerator;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.service.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;

public class RaceController {

    private final NumberGenerator numberGenerator;
    private Race race;

    public RaceController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void start() throws IOException {
        String names = InputView.inputNames();
        String totalRound = InputView.inputTotalRound();
        race = Race.from(new RaceRequest(names, totalRound));
    }

    public void run() {
        OutputView.printStartMessage();
        doRace();
    }

    public void finish() {
        OutputView.printWinners(race.findWinners());
    }

    private void doRace() {
        int leftRound = race.getLeftRound();
        for (int round = 0; round < leftRound; round++) {
            race.play(numberGenerator);
            OutputView.printRound(new RaceResponse(race.getCars()));
        }
    }
}
