package racingcargame.controller;

import racingcargame.model.RacingCar;
import racingcargame.view.RacingCarGameInputView;
import racingcargame.view.RacingCarGameOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGameController {
    private static RacingCarGameInputView inputView = new RacingCarGameInputView();
    private static RacingCarGameOutputView outputView = new RacingCarGameOutputView();
    private static Random random = new Random();
    private static final String SEPARATOR = ",";

    public void start() {
        List<RacingCar> racingCars = createRacingCars();
        int roundNumber = convertRoundNumber();
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

    public String[] splitBySeparator(String carNames) {
        return carNames.split(SEPARATOR);
    }

    public void createRacingCarsWithCarNames(List<RacingCar> racingCars, String[] carNames) {
        for (String carName : carNames) {
            RacingCar car = new RacingCar(carName);
            racingCars.add(car);
        }
    }

    public int convertRoundNumber() {
        int roundNumber = inputView.inputRoundNumber();
        checkRoundNumber(roundNumber);
        return roundNumber;
    }

    public void checkRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new IllegalArgumentException("게임을 시도할 횟수는 0 이상이어야 한다.");
        }
    }

    public void playGame(List<RacingCar> cars, int roundNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            playRound(cars);
            outputView.outputRound(cars);
        }
    }

    public void playRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            int randomNumber = random.nextInt(10);
            car.move(randomNumber);
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
