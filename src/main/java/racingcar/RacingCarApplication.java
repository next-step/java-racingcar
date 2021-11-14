package racingcar;

import racingcar.domain.*;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarOutputView;

public class RacingCarApplication {

    private static final RacingGameController RACING_GAME_CONTROLLER = RacingGameController.getInstance();
    private static final RacingCarInputView INPUT_VIEW = RacingCarInputView.getInstance();
    private static final RacingCarOutputView OUTPUT_VIEW = RacingCarOutputView.getInstance();

    public static void main(String[] args) {
        INPUT_VIEW.carInputPrompt();
        int counts = INPUT_VIEW.input();

        RacingCars racingCars = RacingCars.from(counts, RandomMovingStrategy.getInstance());
        Records records = Records.EMPTY_RECORDS;

        INPUT_VIEW.lapInputPrompt();
        int laps = INPUT_VIEW.input();

        for (int i = 1; i <= laps; i++) {
            racingCars = RACING_GAME_CONTROLLER.race(racingCars);
            records = records.record(Lap.from(i), Record.from(racingCars));
        }

        OUTPUT_VIEW.outputPrompt(records);
    }
}
