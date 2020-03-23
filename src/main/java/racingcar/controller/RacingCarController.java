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

    public RacingCarResponseDto startRacingGame(RacingCarRequestDto racingCarRequestDto) {
        String[] racingCarNames = racingCarRequestDto.getRacingCarNames().split(DELIMITER);
        RacingGameService racingGameService = new RacingGameService(racingCarNames, new RandomMovingStrategy());

        List<RacingScore> racingScores = racingGameService.executeRacingGameNumberOfTimes(racingCarRequestDto.getNumberOfTime());
        List<Car> winners = racingGameService.selectWinners(racingScores);

        return new RacingCarResponseDto(racingScores, winners);
    }
}
