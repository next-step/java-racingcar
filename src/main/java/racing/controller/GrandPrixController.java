package racing.controller;

import lombok.AllArgsConstructor;
import racing.domain.GrandPrix;
import racing.domain.LineUp;
import racing.service.GrandPrixService;
import racing.service.LineUpService;
import racing.view.RacingResultView;
import racing.view.to.RacingInputTO;

@AllArgsConstructor
public class GrandPrixController {
    private final GrandPrixService grandPrixService;
    private final LineUpService lineUpService;
    private final RacingResultView racingResultView = new RacingResultView();

    public GrandPrix create(RacingInputTO racingInputTO) {
        LineUp lineUp = lineUpService.createMachines(racingInputTO.getDrivers());
        return grandPrixService.createGrandPrix(lineUp, racingInputTO.getMaxRounds());
    }

    public void startRace(GrandPrix grandPrix) {
        racingResultView.ready(grandPrix.getLineUp().getLapMapStatus());
        while (grandPrix.getCurrentRound() < grandPrix.getMaxRounds()) {
            grandPrix.runRound();
            racingResultView.viewRound(grandPrix.getLineUp().getLapMapStatus());
        }

    }
}
