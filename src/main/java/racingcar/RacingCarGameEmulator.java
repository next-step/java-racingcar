package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.dto.RacingCarRequestDto;
import racingcar.domain.dto.RacingCarResponseDto;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGameEmulator {
    InputView inputView;
    ResultView resultView;

    public RacingCarGameEmulator() {
        inputView = InputView.getInstance();
        resultView = ResultView.getInstance();
    }

    public void startGame() {
        RacingCarRequestDto requestDto = inputView.getRacingCarRequestDto();
        RacingCarGameController controller = getRacingCarGameController(requestDto);
        RacingCarResponseDto responseDto = controller.startRacing();
        resultView.printResult(responseDto, getRoundSize(requestDto));
    }

    private RacingCarGameController getRacingCarGameController(RacingCarRequestDto requestDto) {
        return RacingCarGameController.from(requestDto);
    }

    private Integer getRoundSize(RacingCarRequestDto requestDto) {
        return requestDto.getAmountValue();
    }

}
