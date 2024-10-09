package racing.domain.game;

import racing.domain.car.Cars;
import racing.domain.dto.CarDTO;
import racing.domain.dto.RacingResultDTO;
import racing.domain.dto.ResultRacingsDTO;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingRandomCalculator racingRandomCalculator;

    public RacingGame(RacingRandomCalculator racingRandomCalculator) {
        this.racingRandomCalculator = racingRandomCalculator;
    }

    /**
     * 주어진 사이클 동안 레이싱하는 기능
     */
    public ResultRacingsDTO racingCycle(Cars cars, int cycle) {
        List<RacingResultDTO> racings = new ArrayList<>();
        ResultRacingsDTO resultRacingsDTO = new ResultRacingsDTO(racings);

        int round = 0;
        while (cycle > 0) {
            cycle--;
            round++;
            cars.carGoAndStop(racingRandomCalculator);
            saveResultRacing(cars, round, racings);
            //ResultView resultView = new ResultView(cars,cycle);
            //resultView.racingPrint(cars,cycle);
        }
        return resultRacingsDTO;
    }

    private static void saveResultRacing(Cars cars, int round, List<RacingResultDTO> racings) {
        List<CarDTO> copyCars = cars.toCarDTO();
        RacingResultDTO racingResultDTO = new RacingResultDTO(copyCars, round);
        racings.add(racingResultDTO);
    }
}
