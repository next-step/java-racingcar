package racingcargame.controller;

import racingcargame.model.RacingCar;
import racingcargame.model.RacingCars;
import racingcargame.model.RacingGame;
import racingcargame.view.RacingCarGameInputView;
import racingcargame.view.RacingCarGameOutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameController {
    private static final String SEPARATOR = ",";
    private final RacingCarGameInputView inputView = new RacingCarGameInputView();
    private final RacingCarGameOutputView outputView = new RacingCarGameOutputView();


    public void start() {
        RacingCars racingCars = new RacingCars(createRacingCars());
        int roundNumber = inputView.inputRoundNumber();
        RacingGame racingGame = new RacingGame(racingCars, roundNumber);
        outputView.outputGame(racingGame.getHistories());
        List<String> winners = racingCars.findWinners();
        outputView.outputWinners(winners);
    }

    private List<RacingCar> createRacingCars() {
        String carNames = inputView.inputCarNames();
        String[] splitCarNames = splitBySeparator(carNames);
        return createRacingCarsWithCarNames(splitCarNames);
    }

    private String[] splitBySeparator(String carNames) {
        return carNames.split(SEPARATOR);
    }

    private List<RacingCar> createRacingCarsWithCarNames(String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }
}
