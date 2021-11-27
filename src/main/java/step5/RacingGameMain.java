package step5;

import step5.dto.CarNames;
import step5.domain.RaceRecordGroup;
import step5.dto.TrialCount;
import step5.domain.RacingGameService;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingGameMain {
    private static final RacingGameService RACING_GAME_SERVICE = RacingGameService.getInstance();
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final ResultView RESULT_VIEW = ResultView.getInstance();
    private static final String WINNER_DELIMITER = ",";

    public static void main(String[] args) {
        CarNames carNames = INPUT_VIEW.readCarNames();
        TrialCount trialCount = new TrialCount(INPUT_VIEW.readTrialCount());

        RaceRecordGroup raceRecordGroup = RACING_GAME_SERVICE.raceStart(carNames, trialCount);

        RESULT_VIEW.renderRaceRecords(raceRecordGroup);
        RESULT_VIEW.renderRaceWinners(raceRecordGroup, WINNER_DELIMITER);
    }
}
