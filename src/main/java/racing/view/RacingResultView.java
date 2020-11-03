package racing.view;

import racing.domain.GrandPrix;
import racing.service.RacingService;
import utils.StringUtils;

public class RacingResultView {

    RacingService racingService = new RacingService();

    public void view(int grandPrixId) {
        GrandPrix grandPrix = racingService.getGrandPrix(grandPrixId);
        ready(grandPrix);
        do {
            grandPrix.runRound();
            viewRound(grandPrix);
        } while (grandPrix.getCurrentRound() < grandPrix.getMaxRounds());
    }

    public void viewRound(GrandPrix grandPrix) {
        grandPrix.getRaceMachines().forEach(raceMachine -> {
            int lap = raceMachine.getLap();
            String machineLapView = StringUtils.repeat("-", lap);
            System.out.println(machineLapView);
        });
        System.out.println();
    }

    public void ready(GrandPrix grandPrix) {
        System.out.println("\n실행 결과");
        viewRound(grandPrix);
    }
}
