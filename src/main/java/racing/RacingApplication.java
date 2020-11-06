package racing;

import racing.controller.GrandPrixController;
import racing.domain.GrandPrix;
import racing.view.RacingInputView;
import racing.view.to.RacingInputTO;

public class RacingApplication {

    private static final RacingInputView racingInputView = new RacingInputView();
    private static final GrandPrixController granPrixController = new GrandPrixController();

    public static void main(String[] args) {
        RacingInputTO racingInputTO = racingInputView.getRacingInput();
        GrandPrix grandPrix = granPrixController.create(racingInputTO);
        granPrixController.startRace(grandPrix);
    }
}
