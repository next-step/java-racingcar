package step4;

import step4.dto.RaceRecordGroup;
import step4.dto.TrialCount;
import step4.service.RacingGameService;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class RacingGameMain {
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final ResultView RESULT_VIEW = ResultView.getInstance();
    private static final String WINNER_DELIMITER = ",";

    public static void main(String[] args) {
        List<String> carsName = INPUT_VIEW.readCarsName();
        TrialCount trialCount = new TrialCount(INPUT_VIEW.readTrialCount());

        RacingGameService racingGameService = new RacingGameService();
        RaceRecordGroup raceRecordGroup = racingGameService.raceStart(carsName, trialCount);

        RESULT_VIEW.renderRaceRecords(raceRecordGroup);
        RESULT_VIEW.renderRaceWinners(raceRecordGroup, WINNER_DELIMITER);
    }
}
