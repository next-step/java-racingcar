package racing_refactoring;

import racing_refactoring.domain.Racing;
import racing_refactoring.domain.RacingResult;
import racing_refactoring.strategy.RacingStrategy;
import racing_refactoring.strategy.RacingStrategyImpl;
import racing_refactoring.ui.InputView;
import racing_refactoring.ui.ResultView;

public class RacingController {
    private static final RacingStrategy RACING_STRATEGY = new RacingStrategyImpl();
    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        
        int round = inputView.getRacingRound();
        String inputCars = inputView.getRacingCar();
        String[] cars = inputCars.split(",");

        Racing racing = new Racing(cars, round);

        for(int trial = 0; trial < round; trial++){
            RacingResult racingResult = racing.race(RACING_STRATEGY);
            resultView.result(racingResult, trial, round);
        }
    }
}
