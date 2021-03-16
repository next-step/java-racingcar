package step4;

import step4.controller.RacingCarGameController;
import step4.domain.dto.RacingCarRequestDto;
import step4.domain.dto.RacingCarResponseDto;
import step4.view.InputView;
import step4.view.ResultView;

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
        return requestDto.getParticipants().getParticipantsLength();
    }

}
