package racingcar.step4.ui;

import racingcar.step4.controller.RacingController;
import racingcar.step4.service.dto.RacingResultDto;
import racingcar.step4.ui.input.InputView;
import racingcar.step4.ui.print.VisualizeRacePrintView;
import racingcar.step4.utils.ConstUtils;

import java.util.List;

public class RacingGameUserView {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> participantsName = inputView.getParticipantsNameInput();
        int roundCount = inputView.getRoundCountInput();

        RacingController racingController = new RacingController(roundCount, participantsName);
        RacingResultDto racingResult = racingController.startRacingContest();

        VisualizeRacePrintView printStrategy = new VisualizeRacePrintView(ConstUtils.DASH_DELIMITER);
        printStrategy.printRacingResult(racingResult);
    }
}
