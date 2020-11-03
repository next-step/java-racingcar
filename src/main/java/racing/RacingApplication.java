package racing;

import racing.domain.GrandPrix;
import racing.service.RacingService;
import racing.view.RacingInputView;

public class RacingApplication {

    private static RacingInputView racingInputView = new RacingInputView();
    private static RacingService racingService = new RacingService();
    public static void main(String[] args) {
        racingInputView.view();
        GrandPrix grandPrix = racingService.createGrandPrix(racingInputView.getMaxMachines(), racingInputView.getMaxRounds());
        grandPrix.runFullRace();
    }
}
