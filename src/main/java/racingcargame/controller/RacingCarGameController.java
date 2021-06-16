package racingcargame.controller;

import racingcargame.model.RacingCar;
import racingcargame.model.RacingCarHistory;
import racingcargame.model.RacingCars;
import racingcargame.model.RandomNumber;
import racingcargame.view.RacingCarGameInputView;
import racingcargame.view.RacingCarGameOutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameController {
    private static final String SEPARATOR = ",";
    private RacingCarGameInputView inputView = new RacingCarGameInputView();
    private RacingCarGameOutputView outputView = new RacingCarGameOutputView();
    private RandomNumber randomNumber = new RandomNumber();
    private RacingCars racingCars;
    private RacingCarHistory racingCarHistory = new RacingCarHistory();

    public void start() {
        racingCars = new RacingCars(createRacingCars());
        int roundNumber = inputView.inputRoundNumber();
        playGame(roundNumber);
        makeResult();
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

    private void playGame(int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            racingCarHistory.addHistory(racingCars.playRound());
        }
        outputView.outputGame(racingCarHistory.getHistory());
    }

    private void makeResult() {
        String winners = racingCars.findWinners();
        outputView.outputWinners(winners);
    }
}
