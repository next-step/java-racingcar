package racingcargame.controller;

import racingcargame.model.RandomNumber;
import racingcargame.model.RacingCar;
import racingcargame.view.RacingCarGameInputView;
import racingcargame.view.RacingCarGameOutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameController {
    private static final String SEPARATOR = ",";

    private RacingCarGameInputView inputView = new RacingCarGameInputView();
    private RacingCarGameOutputView outputView = new RacingCarGameOutputView();
    private RandomNumber randomNumber = new RandomNumber();

    public void start() {
        List<RacingCar> racingCars = createRacingCars();
        int roundNumber = inputView.inputRoundNumber();
        playGame(racingCars, roundNumber);
        makeResult(racingCars);
    }

    public List<RacingCar> createRacingCars() {
        String carNames = inputView.inputCarNames();
        String[] splitCarNames = splitBySeparator(carNames);
        List<RacingCar> racingCars = new ArrayList<>();
        createRacingCarsWithCarNames(racingCars, splitCarNames);
        return racingCars;
    }

    private String[] splitBySeparator(String carNames) {
        return carNames.split(SEPARATOR);
    }

    private void createRacingCarsWithCarNames(List<RacingCar> racingCars, String[] carNames) {
        for (String carName : carNames) {
            RacingCar car = new RacingCar(carName);
            racingCars.add(car);
        }
    }

    public void playGame(List<RacingCar> cars, int roundNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            playRound(cars);
            outputView.outputRound(cars);
        }
    }

    private void playRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.move(randomNumber.getNumber());
        }
    }

    public void makeResult(List<RacingCar> racingCars) {
        int maxScore = findMaxScore(racingCars);
        String winners = findWinners(racingCars, maxScore);
        outputView.outputWinners(winners);
    }

    public int findMaxScore(List<RacingCar> cars) {
        int maxScore = 0;
        for (RacingCar car : cars) {
            if (maxScore < car.getStep()) {
                maxScore = car.getStep();
            }
        }
        return maxScore;
    }

    public String findWinners(List<RacingCar> cars, int maxScore) {
        String winners = "";
        for (RacingCar car : cars) {
            if (car.isWinner(maxScore)) {
                winners += " " + car.getName() + ",";
            }
        }
        winners = winners.substring(0, winners.length() - 1);
        return winners;
    }
}
