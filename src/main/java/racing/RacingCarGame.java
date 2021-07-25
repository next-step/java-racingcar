package racing;

import racing.model.NumberGenerator;
import racing.model.RacingCars;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCarGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.printRacingCarCountInputMessage();
        int racingCarCount = inputView.inputRacingCarCount();

        inputView.printMovementTrialCountInputMessage();
        int movementTrialCount = inputView.inputMovementTrialCount();

        RacingCars racingCars = new RacingCars(racingCarCount);
        NumberGenerator numberGenerator = new NumberGenerator();

        ResultView resultView = new ResultView();
        resultView.printRacingCarGameResultOutputMessage();

        for (int trialOrder = 0; trialOrder < movementTrialCount; trialOrder++) {
            tryMovingRacingCars(racingCars, numberGenerator, resultView);
        }
    }

    private static void tryMovingRacingCars(RacingCars racingCars, NumberGenerator numberGenerator,
                                            ResultView resultView) {
        Map<Integer, Integer> racingCarIndexAndNumber = new LinkedHashMap<>();
        for (int index = 0; index < racingCars.getSize(); index++) {
            numberGenerator.generateRandomNumber();
            racingCarIndexAndNumber.put(index, numberGenerator.getNumber());
        }

        racingCars.moveOrStop(Collections.unmodifiableMap(racingCarIndexAndNumber));
        resultView.printRacingCarsPosition(racingCars.getRacingCarsPosition());
    }
}
