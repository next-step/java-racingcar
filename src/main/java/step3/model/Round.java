package step3.model;

import step3.util.ErrorMessage;
import step3.view.ResultView;

public class Round {

    private static final int INITIAL_ROUND = 0;
    private static final int INVALID_ROUND = 0;
    private int round;

    public Round(int round) {
        validRound(round);
        this.round = round;
    }

    private void validRound(int round) {
        if(round <= INVALID_ROUND) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }

    public void start(Cars cars) {
        for(int i = INITIAL_ROUND; i < round; i++) {
            cars.race();
            end(new ResultView());
        }
    }
    private void end(ResultView view) {
        view.end();
    }
}
