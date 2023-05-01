package racingcar;

import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingFacilitator;
import racingcar.dto.StageRecord;
import racingcar.utils.InputView;
import racingcar.utils.OutputView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {

        List<String> carNames = InputView.inputString();
        PositiveNumber trySize = InputView.inputNumber();

        RacingFacilitator facilitator = RacingFacilitator.participate(trySize, carNames);
        List<StageRecord> stageRecords = facilitator.processRacing();

        OutputView.outputStageRecords(stageRecords);
        OutputView.outputText(facilitator.getWinners());
    }
}
