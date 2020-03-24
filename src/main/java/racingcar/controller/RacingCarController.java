package racingcar.controller;

import racingcar.domain.RacingScore;
import racingcar.domain.car.Car;
import racingcar.domain.car.RandomMovingStrategy;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.service.RacingGameService;

import java.util.List;

public class RacingCarController {
    private static final String DELIMITER = ",";
    private RacingGameService racingGameService;

    public RacingCarController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public RacingCarResponseDto startRacingGame(RacingCarRequestDto racingCarRequestDto) {
        String[] racingCarNames = racingCarRequestDto.getRacingCarNames().split(DELIMITER);
        racingGameService.createRacingCar(racingCarNames);
        List<RacingScore> racingScores = racingGameService
                .executeRacingGameNumberOfTimes(racingCarRequestDto.getNumberOfTime(), new RandomMovingStrategy());
        List<Car> winners = racingGameService.findWinnerInRacingScores(racingScores);

        return new RacingCarResponseDto(racingScores, winners);
    }
}
