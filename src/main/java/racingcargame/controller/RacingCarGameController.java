package racingcargame.controller;

import racingcargame.model.RacingCar;
import racingcargame.view.RacingCarGameInputView;
import racingcargame.view.RacingCarGameOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGameController {
    static RacingCarGameInputView inputView = new RacingCarGameInputView();
    static RacingCarGameOutputView outputView = new RacingCarGameOutputView();
    static Random random = new Random();
    static final String SEPARATOR = ",";

    public void startGame() {
        String carNames = inputView.inputCarNames();
        String[] splitCarNames = splitBySeparator(carNames);
        List<RacingCar> racingCars = new ArrayList<>();
        makeRacingCarsWithCarNames(racingCars, splitCarNames);

        int roundNumber = inputView.inputRoundNumber();
        checkRoundNumber(roundNumber);

        runGame(racingCars, roundNumber);

        int maxScore = getMaxScore(racingCars);
        String winners = getWinners(racingCars, maxScore);
        outputView.outputWinners(winners);
    }

    public void checkRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new IllegalArgumentException("게임을 시도할 횟수는 0 이상이어야 한다.");
        }
    }

    public String[] splitBySeparator(String carNames) {
        return carNames.split(SEPARATOR);
    }

    public void makeRacingCarsWithCarNames(List<RacingCar> racingCars, String[] carNames) {
        for (String carName : carNames) {
            RacingCar car = new RacingCar(carName);
            racingCars.add(car);
        }
    }

    public void runGame(List<RacingCar> cars, int roundNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            startRound(cars);
            outputView.outputRound(cars);
        }
    }

    public void startRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            int randomNumber = random.nextInt(10);
            car.move(randomNumber);
        }
    }

    public int getMaxScore(List<RacingCar> cars) {
        int maxScore = 0;
        for (RacingCar car : cars) {
            if (maxScore < car.getStep()) {
                maxScore = car.getStep();
            }
        }
        return maxScore;
    }

    public String getWinners(List<RacingCar> cars, int maxScore) {
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
