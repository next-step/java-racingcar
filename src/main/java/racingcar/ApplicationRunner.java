package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.controller.dto.CarRequestDto;
import racingcar.controller.dto.CarResponseDto;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {
        ConsoleInputView consoleInputView = new ConsoleInputView();
        CarRequestDto carRequestDto = consoleInputView.input();

        RacingGameController racingGameController = new RacingGameController();
        List<List<CarResponseDto>> responses = racingGameController.racingGameStart(carRequestDto);

        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        for (List<CarResponseDto> response : responses) {
            consoleOutputView.print(response);
        }
    }
}
