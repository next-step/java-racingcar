package racingcar;

import racingcar.domain.GameInfo;
import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.dto.InputValueDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        int numberOfCar = InputView.inputNumberOfCar();
        int numberOfPhase = InputView.inputNumberOfPhase();

        InputValueDto inputValueDto = new InputValueDto(numberOfCar, numberOfPhase);

//        GameInfo gameInfo = new GameInfo(inputValueDto.getNumberOfCar(), inputValueDto.getNumberOfPhase());

        RacingGame racingGame = new RacingGame(inputValueDto);

        GameResult gameResult = racingGame.startGame(new RandomNumberGenerator());

        OutputView.printGameResult(gameResult);
    }
}
