package racing.controller;

import racing.domain.GrandPrix;
import racing.domain.LineUp;
import racing.service.GranPrixService;
import racing.service.LineUpService;
import racing.view.RacingResultView;
import racing.view.to.RacingInputTO;

public class GrandPrixController {
    private final GranPrixService granPrixService = new GranPrixService();
    private final LineUpService lineUpService = new LineUpService();
    private final RacingResultView racingResultView = new RacingResultView();

    public GrandPrix create(RacingInputTO racingInputTO) {
        LineUp lineUp = lineUpService.createRandomAccelerateMachines(racingInputTO.getMaxMachines());
        return granPrixService.createGrandPrix(lineUp, racingInputTO.getMaxRounds());
    }

    public void startRace(GrandPrix grandPrix) {
        racingResultView.ready(grandPrix.getLineUp().getLapMapStatus());
        while (grandPrix.getCurrentRound() < grandPrix.getMaxRounds()) {
            grandPrix.runRound();
            racingResultView.viewRound(grandPrix.getLineUp().getLapMapStatus());
        }

    }
}
