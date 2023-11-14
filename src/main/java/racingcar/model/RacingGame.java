package racingcar.model;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.*;

public class RacingGame {
    private static final Random rand = new Random();
    private static final int RANDOM_VALUE_BOUND = 10;
    private static final String ERR_NEGATIVE_NUMBER = "Negative numbers are not allowed.";

    private final Referee referee = new Referee();
    private List<RacingCar> cars;
    private List<RacingCar> winners;


    public RacingGame(List<String> carNameList, int roundNumber) {
        // validation
        validateRoundNumber(roundNumber);

        // setting
        makeCars(carNameList);
    }

    private void validateRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new RuntimeException(ERR_NEGATIVE_NUMBER);
        }
    }

    private void makeCars(List<String> carNameList) {
        int carNumber = carNameList.size();

        RacingCar[] cars = new RacingCar[carNumber];
        for (int i=0; i<carNumber; i++) {
            RacingCar newCar = new RacingCar(carNameList.get(i));
            cars[i] = newCar;
        }

        this.cars = Arrays.asList(cars);
    }


    public void playOneRound() {
        for (RacingCar car : this.cars) {
            car.moveOrStop(getRandomValue());
        }
    }

    private static int getRandomValue() {
        return rand.nextInt(RANDOM_VALUE_BOUND);
    }


    public void endGame() {
        this.winners = referee.findWinner(this.cars);
    }


    public List<RacingCar> getCars() {
        return this.cars;
    }

    public List<RacingCar> getWinners() {
        return this.winners;
    }
}
