package racingcar.step4.view;

import racingcar.step4.domain.Names;
import racingcar.step4.domain.move.RandomMoveStrategy;
import racingcar.step4.service.RacingService;
import racingcar.step4.service.dto.RacingResultDto;
import racingcar.step4.view.input.InputView;
import racingcar.step4.view.print.VisualizeRacePrintView;
import racingcar.step4.utils.ConstUtils;

import java.util.List;

public class RacingGameUserView {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Names participantsName = new Names(inputView.getParticipantsNameInput());
        int roundCount = inputView.getRoundCountInput();

        RacingService racingService = new RacingService(new RandomMoveStrategy(), roundCount, participantsName);
        RacingResultDto racingResult = racingService.startRacingContest();

        VisualizeRacePrintView printStrategy = new VisualizeRacePrintView(ConstUtils.DASH_DELIMITER);
        printStrategy.printRacingResult(racingResult);
    }
}
