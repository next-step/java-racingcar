package racingcar;

import racingcar.domains.RacingCar;
import racingcar.domains.RacingResult;
import racingcar.views.InputView;
import racingcar.views.ResultView;

import java.util.*;

public class RacingMain {

    public static void main(String[] args) {
        Map<String, Integer> carInfos = InputView.input();

        int carNumTotal = carInfos.get(InputView.CAR_NUM_TOTAL);
        int roundNumTotal = carInfos.get(InputView.ROUND_NUM_TOTAL);

        RacingGame racingGame = new RacingGame();
        List<RacingCar> racingCars = new ArrayList<>();

        racingGame.initiateCars(racingCars, carNumTotal);

        List<RacingResult> results = racingGame.startRace(racingCars, roundNumTotal);

        ResultView.showRaceResult(results);
    }

}
