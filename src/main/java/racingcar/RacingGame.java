package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private int roundNumber;
    private RacingCar[] cars;
    private int round=1;

    private int winRecord = 0;
    private List<RacingCar> winnerList = new ArrayList<RacingCar>();

    public void play() {
        InputView inputView = new InputView();
        inputView.input();
        makeGame(inputView.getCarNameList(), inputView.getRoundNumber());
        startGame();
        endGame();
    }

    private void makeGame(String[] carNameList, int roundNumber) {
        this.makeCars(carNameList);
        this.roundNumber = roundNumber;
    }

    private void makeCars(String[] carNameList) {
        int carNumber = carNameList.length;
        this.cars = new RacingCar[carNumber];
        for (int i=0; i<carNumber; i++) {
            RacingCar newCar = new RacingCar(carNameList[i]);
            this.cars[i] = newCar;
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
            car.moveOrStop(RacingCar.getRandomValue());
        }
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
