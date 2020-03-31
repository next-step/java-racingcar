package racingcar;

import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarRequestDto racingCarRequestDto = InputView.inputParams();
        RacingGameService racingGameService = new RacingGameService();

        RacingCarResponseDto racingCarResponseDto = racingGameService.run(racingCarRequestDto);

        ResultView.printResult(racingCarResponseDto);
    }
}
