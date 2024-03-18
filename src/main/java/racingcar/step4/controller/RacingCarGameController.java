package racingcar.step4.controller;

import racingcar.step4.domain.Cars;
import racingcar.step4.domain.RacingCarGame;
import racingcar.step4.domain.factory.CarFactory;
import racingcar.step4.domain.factory.RacingCarGameFactory;
import racingcar.step4.view.InputValue;
import racingcar.step4.view.InputView;
import racingcar.step4.view.ResultView;
import racingcar.step4.view.dto.RacingCarGameDto;
import racingcar.step4.view.dto.RacingCarGameWinnerDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameController {

  private final InputView inputView;
  private final ResultView resultView;

  public RacingCarGameController(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public void run() {
    InputValue input = inputView.receive();

    Cars cars = CarFactory.of(input.getInputName());
    List<RacingCarGame> racingCarGames = RacingCarGameFactory.of(input.getTryCount(), cars);
    racingCarGames.forEach(RacingCarGame::start);

    List<RacingCarGameDto> racingCarGameDtos = racingCarGames.stream().map(RacingCarGameDto::covert).collect(Collectors.toList());
    RacingCarGameWinnerDto winnerDto = RacingCarGameWinnerDto.covert(RacingCarGame.findFinalGame(racingCarGames).getWinners());

    resultView.printResult(racingCarGameDtos);
    resultView.printFinalWinners(winnerDto);
  }
}
