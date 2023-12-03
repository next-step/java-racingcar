package racinggame.service;

import racinggame.domain.Cars;
import racinggame.domain.Winner;
import racinggame.dto.RacingInputDTO;
import racinggame.dto.RacingResultDTO;
import racinggame.dto.RacingRoundResultDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    public static RacingResultDTO start(RacingInputDTO racingInputDTO) {
        Cars carList = Cars.createCars(racingInputDTO.getCarNames());
        List<RacingRoundResultDTO> racingRoundResultDTOS = IntStream.rangeClosed(1, racingInputDTO.getGameCount())
                .mapToObj(round -> new RacingRoundResultDTO(carList.carMove()))
                .collect(Collectors.toList());
        Winner winner = new Winner(carList.getCarList());
        return new RacingResultDTO(carList.getCarList(), winner.getWinners(), racingRoundResultDTOS);
    }
}
