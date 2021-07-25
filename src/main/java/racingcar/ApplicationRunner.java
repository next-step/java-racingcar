package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.controller.dto.RacingGameRequestDto;
import racingcar.controller.dto.RacingGameResponseDto;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {
        ConsoleInputView consoleInputView = new ConsoleInputView();
        RacingGameRequestDto racingGameRequestDto = consoleInputView.input();

        RacingGameController racingGameController = new RacingGameController();
        List<RacingGameResponseDto> responses = racingGameController.start(racingGameRequestDto);

        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        for (RacingGameResponseDto response : responses) {
            consoleOutputView.print(response);
        }
    }
}
