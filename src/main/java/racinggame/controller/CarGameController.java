package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.domain.Winner;
import racinggame.dto.RacingInputDTO;
import racinggame.dto.RacingResultDTO;
import racinggame.dto.RacingRoundResultDTO;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarGameController {

    private static CarGameController instance;

    public static CarGameController getInstance() {
        if (instance == null) {
            instance = new CarGameController();
        }
        return instance;
    }

    public void playGame() {
        RacingInputDTO racingInputDTO = InputView.printRequestGameValue();
        try {
            RacingResultDTO racingResultDTO = start(racingInputDTO);
            ResultView.printResult(racingResultDTO);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            playGame();
        }
    }

    private RacingResultDTO start(RacingInputDTO racingInputDTO) {
        Cars carList = Cars.createCars(racingInputDTO.getCarNames());
        List<RacingRoundResultDTO> racingRoundResultDTOS = IntStream.rangeClosed(1, racingInputDTO.getGameCount())
                .mapToObj(round -> new RacingRoundResultDTO(carList.carMove()))
                .collect(Collectors.toList());
        Winner winner = new Winner(carList.getCarList());
        return new RacingResultDTO(carList.getCarList(), winner.getWinners(), racingRoundResultDTOS);
    }
}
