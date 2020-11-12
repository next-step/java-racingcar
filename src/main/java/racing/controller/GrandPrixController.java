package racing.controller;

import lombok.AllArgsConstructor;
import racing.domain.GrandPrix;
import racing.domain.LineUp;
import racing.service.GrandPrixService;
import racing.service.LineUpService;
import racing.view.RacingInputView;
import racing.view.RacingResultView;
import racing.view.to.RacingInputTO;

@AllArgsConstructor
public class GrandPrixController {
    private final GrandPrixService grandPrixService;
    private final LineUpService lineUpService;

    public GrandPrix create() {
        RacingInputTO racingInput = RacingInputView.getRacingInput();
        LineUp lineUp = lineUpService.createMachines(racingInput.getDrivers());
        return grandPrixService.createGrandPrix(lineUp, racingInput.getMaxRounds());
    }

    public void startRace(GrandPrix grandPrix) {
        RacingResultView.ready(grandPrix.getLineUp());
        while (grandPrix.getCurrentRound() < grandPrix.getMaxRounds()) {
            grandPrix.runRound();
            RacingResultView.viewRound(grandPrix.getLineUp());
        }
        RacingResultView.viewChampion(grandPrix.getLineUp());
    }
}
