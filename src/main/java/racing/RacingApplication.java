package racing;

import racing.view.RacingInputView;
import racing.view.RacingResultView;

public class RacingApplication {

    private static final RacingInputView racingInputView = new RacingInputView();
    private static final RacingResultView racingResultView = new RacingResultView();

    public static void main(String[] args) {
        racingInputView.view();
        int grandPrixId = racingInputView.getGrandPrixId();
        racingResultView.view(grandPrixId);
    }
}
