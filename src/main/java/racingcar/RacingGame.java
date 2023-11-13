package racingcar;

import java.util.*;

public class RacingGame {
    private static final Random rand = new Random();
    private static final int RANDOM_VALUE_BOUND = 10;
    private static final String ERR_NEGATIVE_NUMBER = "Negative numbers are not allowed.";

    private int roundNumber;
    private RacingCar[] cars;
    private int round=1;

    private int winRecord = 0;
    private List<RacingCar> winnerList = new ArrayList<RacingCar>();

    public void play() {
        makeGame();
        startGame();
        endGame();
    }

    private void makeGame() {
        InputView inputView = new InputView();

        List<String> carNameList = inputView.inputCarNameList();
        int roundNumber = inputView.inputRoundNumber();

        this.makeCars(carNameList);
        this.setRoundNumber(roundNumber);
    }

    private void makeCars(List<String> carNameList) {
        int carNumber = carNameList.size();
        this.cars = new RacingCar[carNumber];
        for (int i=0; i<carNumber; i++) {
            RacingCar newCar = new RacingCar(carNameList.get(i));
            this.cars[i] = newCar;
        }
    }

    private void setRoundNumber(int roundNumber) {
        validateRoundNumber(roundNumber);
        this.roundNumber = roundNumber;
    }

    private void validateRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new RuntimeException(ERR_NEGATIVE_NUMBER);
        }
    }

    private void startGame() {
        for (int i = 0; i<this.roundNumber; i++) {
            this.playOneRound();
            ResultView.printRoundResult(this);
            round += 1;
        }
    }

    private void playOneRound() {
        for (RacingCar car : this.cars) {
            car.moveOrStop(getRandomValue());
        }
    }

    public static int getRandomValue() {
        return rand.nextInt(RANDOM_VALUE_BOUND);
    }

    public boolean checkFirstRound() {
        if (this.round == 1) {
            return true;
        }
        return false;
    }

    public RacingCar[] getCars() {
        return this.cars;
    }

    private void endGame() {
        List<RacingCar> finalWinners = findWinner();
        ResultView.printWinners(finalWinners);
    }

    private List<RacingCar> findWinner() {
        for (RacingCar car : this.cars) {
            updateWinnerList(car);
        }
        return winnerList;
    }

    private List<RacingCar> updateWinnerList(RacingCar car) {
        if (car.getLocation() > winRecord) {
            winRecord = car.getLocation();
            winnerList = new ArrayList<RacingCar>();
            winnerList.add(car);
            return winnerList;
        }

        if (car.getLocation() == winRecord) {
            winnerList.add(car);
            return winnerList;
        }

        return winnerList;
    }
}
