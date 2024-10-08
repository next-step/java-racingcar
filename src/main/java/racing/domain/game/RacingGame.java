package racing.domain.game;

import racing.domain.car.Cars;
import racing.domain.result.ResultRacing;
import racing.domain.result.ResultRacings;

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
    public ResultRacings racingCycle(Cars cars, int cycle) {
        List<ResultRacing> racings = new ArrayList<>();
        ResultRacings resultRacings = new ResultRacings(racings);

        int round = 0;
        while (cycle > 0) {
            cycle--;
            round ++;
            cars.carGoAndStop(racingRandomCalculator);
            Cars copyCars = new Cars(cars);
            ResultRacing resultRacing = new ResultRacing(copyCars, round);
            racings.add(resultRacing);
            //ResultView resultView = new ResultView(cars,cycle);
            //resultView.racingPrint(cars,cycle); //뷰 분리
        }
        return resultRacings;
    }
}
