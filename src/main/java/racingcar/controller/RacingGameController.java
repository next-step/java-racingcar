package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.dto.GameResultInfo;
import racingcar.dto.RacingCarDto;
import racingcar.service.RacingCarService;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingCarService racingCarService;
    private final OutputView outputView;

    public RacingGameController(RacingCarService racingCarService, OutputView outputView) {
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run(List<String> carNames, PositiveNumber numberOfAttempts) {
        informWinners(startAllGames(createRacingCars(carNames), createNumberOfAttempts(numberOfAttempts)));
    }

    private void informWinners(List<RacingCarDto> finalGameResult) {
        outputView.printWinners(createRacingCarsWith(finalGameResult).findWinners());
    }

    private RacingCars createRacingCarsWith(List<RacingCarDto> finalGameResult) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (RacingCarDto racingCarDto : finalGameResult) {
            racingCars.add(new RacingCar(racingCarDto.getCarName(), racingCarDto.getPosition()));
        }
        return new RacingCars(racingCars);
    }

    private List<RacingCarDto> startAllGames(RacingCars racingCars, NumberOfAttempts numberOfAttempts) {
        outputView.printGameResultMessage();
        List<RacingCarDto> racingCarDtos;
        do {
            GameResultInfo gameResultInfo = racingCarService.startGame(racingCars, numberOfAttempts);
            numberOfAttempts = gameResultInfo.getLeftNumberOfAttempts();
            racingCarDtos = gameResultInfo.getRacingCarDtos();
            outputView.printGameResult(racingCarDtos);
        } while (numberOfAttempts.isLeft());
        return racingCarDtos;
    }

    private RacingCars createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return new RacingCars(racingCars);
    }

    private NumberOfAttempts createNumberOfAttempts(PositiveNumber numberOfAttempts) {
        return new NumberOfAttempts(numberOfAttempts.getNumber());
    }
}
