package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.dto.TurnRequestDto;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        int turnCount = TurnRequestDto.toEntity(InputView.setTurnCount()).getValue();
        
        RacingController racingController = RacingController.getInstance(InputView.setNames(), turnCount);
        racingController.start();
        racingController.printGameResult();
    }
}