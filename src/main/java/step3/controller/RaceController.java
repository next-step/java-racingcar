package step3.controller;

import step3.domain.CarName;
import step3.domain.RacingGame;
import step3.dto.InputDTO;
import step3.dto.OutputDTO;
import step3.view.InputView;
import step3.view.ResultView;

public class RaceController {

    public InputDTO readInput(InputView inputView) {
        return  new InputDTO(
                CarName.splitCarNames(inputView.readStringInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")),
                inputView.readIntInput("시도할 회수는 몇회인가요?"),
                inputView.readIntInput("전진할 기준값은 10을 기준으로 얼마인가요?")
        );
    }

    public OutputDTO callService(RacingGame racingGame, InputDTO inputDTO) {
        return racingGame.service(inputDTO);
    }

    public void writeOutput(ResultView resultView, OutputDTO outputDTO) {
        resultView.printRacingLog(outputDTO.getRacingLog());
        resultView.printWinner(outputDTO.getWinners());
    }

    public void service(RacingGame racingGame, InputView inputView, ResultView resultView) {
        InputDTO inputDTO = readInput(inputView);
        OutputDTO outputDTO = callService(racingGame, inputDTO);
        writeOutput(resultView, outputDTO);
    }

    public static void main(String[] args) {
        RaceController raceController = new RaceController();
        raceController.service(new RacingGame(), new InputView(), new ResultView());
    }
}
