package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        RacingCarController racingCarController = new RacingCarController(new RacingGameService());
        String racingCarNames = InputView.inputRacingCars();
        int numberOfTime = InputView.inputRacingGameTimes();

        RacingCarResponseDto racingCarResponseDto = racingCarController
                .startRacingGame(new RacingCarRequestDto(racingCarNames, numberOfTime));

        resultView.print(racingCarResponseDto.getRacingScores());
        resultView.printWinner(racingCarResponseDto.getWinners());
    }
}
