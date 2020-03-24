package controller;

import domain.Car;
import domain.GameRecord;
import domain.GameRole;
import ui.InputView;
import ui.ResultView;
import util.CarFactory;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int MOVE_CONDITION = 4;

    private GameRole gameRole;
    private List<Car> cars;
    private GameRecord gameRecord;

    public RacingGame(GameRole gameRole) {
        this.gameRole = gameRole;
        this.cars = CarFactory.createCars(gameRole.getNames());
        this.gameRecord = new GameRecord(cars);
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameRole gameRole = inputView.getGameRole();
        RacingGame racingGame = new RacingGame(gameRole);
        int numberOfAttempts = gameRole.getNumberOfAttempts();
        for (int i = 0; i < numberOfAttempts; i++) {
            int[] conditions = racingGame.createRandomNumbers(gameRole.getNames().size());
            racingGame.playGame(conditions);
        }
        racingGame.checkWinners();
        racingGame.printResult();
    }

    public void playGame(int[] conditions) {
        for (int i = 0; i < cars.size(); i++) {
            tryMoveCar(cars.get(i), conditions[i]);
        }

        gameRecord.saveCurrentLocation();
    }

    public void tryMoveCar(Car car, int condition) {
        if (condition >= MOVE_CONDITION) {
            car.move();
        }
    }

    public int[] createRandomNumbers(int numberOfCars) {
        Random random = new Random();
        int[] randoms = new int[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            randoms[i] = random.nextInt(10);
        }

        return randoms;
    }

    private void checkWinners() {
        gameRecord.checkWinners();
    }

    private void printResult() {
        ResultView resultView = new ResultView(gameRecord);
        resultView.printResult(gameRole.getNumberOfAttempts());
    }

}
